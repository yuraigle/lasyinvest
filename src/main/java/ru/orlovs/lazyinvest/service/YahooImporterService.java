package ru.orlovs.lazyinvest.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import ru.orlovs.lazyinvest.domain.Asset;
import ru.orlovs.lazyinvest.domain.AssetRepo;
import ru.orlovs.lazyinvest.domain.DayCandle;
import ru.orlovs.lazyinvest.domain.DayCandleRepo;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

@Log4j2
@Service
public class YahooImporterService {

    private final RestTemplate restTemplate;
    private final DayCandleRepo dayCandleRepo;
    private final AssetRepo assetRepo;

    public YahooImporterService(
            RestTemplateBuilder restTemplateBuilder,
            DayCandleRepo dayCandleRepo,
            AssetRepo assetRepo
    ) {
        this.restTemplate = restTemplateBuilder.build();
        this.dayCandleRepo = dayCandleRepo;
        this.assetRepo = assetRepo;
    }

    @Transactional
    public void importDataFromYahoo(String symbol) throws Exception {
        log.info("importing " + symbol + "...");

        String yahooSymbol = symbol;
        if (symbol.equals("US500")) {
            yahooSymbol = "^GSPC";
        }

        String urlBase = "https://query1.finance.yahoo.com/v8/finance/chart/";
        String urlParams = "interval=1d&range=10y";
        YahooChartDto res = restTemplate.getForObject(urlBase + yahooSymbol + "?" + urlParams, YahooChartDto.class);

        Asset asset = assetRepo.findBySymbol(symbol)
                .orElseThrow(() -> new Exception("Asset not found"));

        List<DayCandle> importedCandles = new ArrayList<>();
        if (res != null && res.getChart() != null) {
            YahooChartDto.Chart.Result result = res.getChart().getResult().get(0);
            for (int i = 0; i < result.getTimestamp().size(); i++) {
                YahooChartDto.Chart.Result.Indicators.Quote q = result.getIndicators().getQuote().get(0);

                DayCandle candle = new DayCandle();
                candle.setAsset(asset);
                candle.setLow(q.getLow().get(i));
                candle.setHigh(q.getHigh().get(i));
                candle.setClose(q.getClose().get(i));
                candle.setOpen(q.getOpen().get(i));
                candle.setVolume(q.getVolume().get(i));

                LocalDate d1 = LocalDateTime.ofInstant(Instant.ofEpochMilli(result.getTimestamp().get(i) * 1000),
                        TimeZone.getDefault().toZoneId()).toLocalDate();
                candle.setDate(d1);

                importedCandles.add(candle);
            }
        }

        dayCandleRepo.deleteAllByAsset(asset);
        dayCandleRepo.saveAll(importedCandles);
    }
}
