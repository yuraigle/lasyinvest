package ru.orlovs.lazyinvest.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DayCandleRepo extends JpaRepository<DayCandle, Long> {

    void deleteAllByAsset(Asset asset);
}
