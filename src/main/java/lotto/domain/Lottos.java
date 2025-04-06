package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> values;

    public Lottos(List<Lotto> values) {
        this.values = List.copyOf(values);
    }

    public int size() {
        return values.size();
    }

    public List<Lotto> getValues() {
        return Collections.unmodifiableList(values);
    }
}
