package study.lotto.step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Set<Integer>> numbers() {
        return lottos.stream()
                .map(this::numbersOf)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int size() {
        return lottos.size();
    }

    private Set<Integer> numbersOf(Lotto lotto) {
        return lotto.numbers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lottos)) return false;
        Lottos that = (Lottos) o;
        return Objects.equals(lottos, that.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
