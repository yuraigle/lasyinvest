package ru.orlovs.lazyinvest.cron;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.orlovs.lazyinvest.service.YahooImporterService;

@Log4j2
@Component
@RequiredArgsConstructor
public class DayCandlesImporter {

    private final YahooImporterService yahooImporter;

    @Scheduled(initialDelay = 5000L, fixedDelay = 86400000L) // 1day
    private void run() {
        try {
            yahooImporter.importDataFromYahoo("US500");
            yahooImporter.importDataFromYahoo("AAPL");
            yahooImporter.importDataFromYahoo("MSFT");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
