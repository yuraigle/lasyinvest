package ru.orlovs.lazyinvest.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IndicatorRepo extends JpaRepository<Indicator, Long> {
}
