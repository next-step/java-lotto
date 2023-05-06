package study.lotto.step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int size() {
        return lottos.size();
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
