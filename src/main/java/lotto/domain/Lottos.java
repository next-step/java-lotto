package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {
    private List<Lotto> values = new ArrayList<>();

    public static Lottos create(int quantity) {
        return new Lottos(quantity);
    }
    public Lottos(int quantity) {
        IntStream.range(0, quantity)
                .forEach(i -> values.add(Lotto.create()));
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
}
