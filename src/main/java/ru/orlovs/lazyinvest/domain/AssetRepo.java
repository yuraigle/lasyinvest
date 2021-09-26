package ru.orlovs.lazyinvest.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssetRepo extends JpaRepository<Asset, Long> {

    Optional<Asset> findBySymbol(String symbol);
}
