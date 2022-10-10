package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> values;

    public static Lottos create(List<Lotto> values) {
        return new Lottos(values);
    }

    public Lottos(List<Lotto> values) {
        this.values = values;
    }

    public List<Lotto> values() {
        return Collections.unmodifiableList(values);
    }

    public int quantity() {
        return values.size();
    }

    public Lottos add(Lottos other) {
        this.values.addAll(other.values);

        return new Lottos(values);
    }
}
