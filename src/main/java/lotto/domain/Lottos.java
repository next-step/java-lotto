package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public record Lottos(List<Lotto> lottos) {

    public Lottos(Lotto... lottos) {
        this(List.of(lottos));
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = List.copyOf(lottos);
    }

    public List<Lotto> lottos() {
        return lottos;
    }

    public int size() {
        return lottos.size();
    }

    public Lottos merge(Lottos other) {
        List<Lotto> merged = new ArrayList<>(this.lottos);
        merged.addAll(other.lottos);
        return new Lottos(merged);
    }
}
