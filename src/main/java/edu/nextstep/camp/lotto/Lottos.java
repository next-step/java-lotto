package edu.nextstep.camp.lotto;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class Lottos {
    private final Collection<Lotto> lottos;

    public static Lottos of(Collection<Lotto> lottos) {
        if (lottos == null || lottos.isEmpty()) {
            throw new IllegalArgumentException("invalid input: lottos must not be null or empty");
        }

        return new Lottos(lottos);
    }

    private Lottos(Collection<Lotto> lottos) {
        this.lottos = Collections.unmodifiableCollection(lottos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos others = (Lottos) o;
        return lottos.containsAll(others.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
