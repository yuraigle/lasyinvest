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
@Table(name = "indicators")
public class Indicator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Indicator)) return false;
        Indicator indicator = (Indicator) o;
        return Objects.equals(id, indicator.id) && Objects.equals(name, indicator.name)
                && Objects.equals(description, indicator.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
