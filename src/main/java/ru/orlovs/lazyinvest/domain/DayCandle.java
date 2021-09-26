package ru.orlovs.lazyinvest.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "day_candles")
@Entity
public class DayCandle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, insertable = false)
    private Long id;

    @ManyToOne
    private Asset asset;

    private LocalDate date;
    private BigDecimal low;
    private BigDecimal high;
    private BigDecimal close;
    private BigDecimal open;
    private Long volume;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DayCandle)) return false;
        DayCandle dayCandle = (DayCandle) o;
        return Objects.equals(id, dayCandle.id) && Objects.equals(asset, dayCandle.asset)
                && Objects.equals(date, dayCandle.date) && Objects.equals(low, dayCandle.low)
                && Objects.equals(high, dayCandle.high) && Objects.equals(close, dayCandle.close)
                && Objects.equals(open, dayCandle.open) && Objects.equals(volume, dayCandle.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, asset, date, low, high, close, open, volume);
    }
}
