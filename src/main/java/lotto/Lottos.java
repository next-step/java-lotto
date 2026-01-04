package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}
