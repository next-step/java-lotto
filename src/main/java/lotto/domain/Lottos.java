package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> values;

    private Lottos(List<Lotto> values) {
        this.values = values;
    }

    public static Lottos copyOf(List<Lotto> values) {
        return new Lottos(List.copyOf(values)); // 내부 리스트 불변화
    }

    public int size() {
        return values.size();
    }

    public List<Lotto> getValues() {
        return Collections.unmodifiableList(values);
    }
}
