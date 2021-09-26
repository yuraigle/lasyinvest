package ru.orlovs.lazyinvest.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PortfolioAsset {
    private Asset asset;
    private BigDecimal weight;
    private Long count;
}
