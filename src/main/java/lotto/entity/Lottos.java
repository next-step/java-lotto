package lotto.entity;

import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> values;

    public Lottos(List<Lotto> values) {
        this.values = values;
    }

    public List<Lotto> getValues() {
        return Collections.unmodifiableList(values);
    }

}
