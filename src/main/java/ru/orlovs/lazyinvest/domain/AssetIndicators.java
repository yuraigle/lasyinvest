package ru.orlovs.lazyinvest.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "asset_indicators")
public class AssetIndicators {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal pe;
    private BigDecimal de;
    private BigDecimal ltDe;
    private BigDecimal div;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AssetIndicators)) return false;
        AssetIndicators that = (AssetIndicators) o;
        return Objects.equals(id, that.id) && Objects.equals(pe, that.pe) && Objects.equals(de, that.de)
                && Objects.equals(ltDe, that.ltDe) && Objects.equals(div, that.div);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pe, de, ltDe, div);
    }
}
