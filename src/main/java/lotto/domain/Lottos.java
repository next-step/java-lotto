package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> values;

    public Lottos(List<Lotto> values) {
        this.values = List.copyOf(values);
    }

    public List<Lotto> values() {
        return values;
    }

    public int size() {
        return values.size();
    }

    public Lottos merge(Lottos other) {
        List<Lotto> merged = new ArrayList<>(this.values);
        merged.addAll(other.values);
        return new Lottos(merged);
    }
}
