package lotto.model;

import java.util.List;

public class Lotto {

    public static final int eachAmount = 1_000;

    private final List<Number> values;

    public Lotto(List<Number> values) {
        this.values = values;
    }

    public int match(Lotto lotto) {
        return (int) lotto.values.stream()
                                 .filter(values::contains)
                                 .count();
    }

    @Override
    public String toString() {
        return String.valueOf(values);
    }
}
