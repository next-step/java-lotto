package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {
    private static final String ZERO_QUANTITY_EXCEPTION_MESSAGE = "0개 생성은 불가능합니다.";
    private List<Lotto> values = new ArrayList<>();

    public static Lottos create(int quantity) {
        return new Lottos(quantity);
    }

    public Lottos(int quantity) {
        if (quantity == 0) {
            throw new IllegalArgumentException(ZERO_QUANTITY_EXCEPTION_MESSAGE);
        }

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
