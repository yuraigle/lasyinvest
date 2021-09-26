package ru.orlovs.lazyinvest.domain;

import lombok.Data;

import java.util.List;

@Data
public class Portfolio {
    private List<PortfolioAsset> assets;
    private Integer reallocateEach;
}
