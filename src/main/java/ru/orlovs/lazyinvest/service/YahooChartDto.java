package ru.orlovs.lazyinvest.service;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class YahooChartDto {

    private Chart chart;

    @Data
    public static class Chart {

        private List<Result> result;

        @Data
        public static class Result {
            private Meta meta;
            private List<Long> timestamp;
            private Indicators indicators;

            @Data
            public static class Meta {
                private String symbol;
            }

            @Data
            public static class Indicators {
                private List<Quote> quote;

                @Data
                public static class Quote {
                    private List<BigDecimal> low;
                    private List<BigDecimal> open;
                    private List<BigDecimal> high;
                    private List<Long> volume;
                    private List<BigDecimal> close;
                }
            }
        }
    }
}
