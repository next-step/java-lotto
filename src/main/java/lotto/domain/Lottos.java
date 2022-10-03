package lotto.domain;

import lotto.domain.type.Rank;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private static final String ZERO_QUANTITY_EXCEPTION_MESSAGE = "0이하 생성은 불가능합니다.";

    private final List<Lotto> values;

    public static Lottos create(int quantity) {
        return new Lottos(quantity);
    }

    public Lottos(int quantity) {
        if (isLessThanEqualZero(quantity)) {
            throw new IllegalArgumentException(ZERO_QUANTITY_EXCEPTION_MESSAGE);
        }

        values = IntStream.range(0, quantity)
                .mapToObj(i -> Lotto.create())
                .collect(Collectors.toList());
    }

    public Lottos(List<Lotto> values) {
        this.values = values;
    }

    private boolean isLessThanEqualZero(int quantity) {
        return quantity == 0;
    }

    public List<Rank> match(Lotto lotto) {
        return values.stream()
                .map(l -> l.rank(lotto))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Lotto> values() {
        return Collections.unmodifiableList(values);
    }

    public int quantity() {
        return values.size();
    }
}
