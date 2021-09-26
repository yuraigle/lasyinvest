package ru.orlovs.lazyinvest.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "assets")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, insertable = false)
    private Long id;

    private String symbol;

    private String name;

    private String icon;

    private Country country;

    @ManyToOne
    private AssetSector sector;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Asset)) return false;
        Asset asset = (Asset) o;
        return Objects.equals(id, asset.id) && Objects.equals(symbol, asset.symbol)
                && Objects.equals(name, asset.name) && Objects.equals(icon, asset.icon)
                && country == asset.country && Objects.equals(sector, asset.sector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, symbol, name, icon, country, sector);
    }
}
