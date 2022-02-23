package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> values;

    public Lottos(List<Lotto> lottos) {
        this.values = new ArrayList<>(lottos);
    }

    public int size() {
        return values.size();
    }

    public void add(Lottos lottos) {
        values.addAll(new ArrayList<>(lottos.values));
    }

    public List<Lotto> getValues() {
        return new ArrayList<>(values);
    }
}
