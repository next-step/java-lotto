package lotto.model;

import java.util.List;

public class Lotto {

    public static final int eachAmount = 1_000;

    private final List<Number> values;

    public Lotto(List<Number> values) {
        this.values = values;
    }

    public static int getLottoCount(int amount) {
        return amount / eachAmount;
    }

    public int getMachedCount(Lotto lotto) {
        return (int) values.stream()
                           .filter(lotto.values::contains)
                           .count();
    }

    public boolean contains(Number number) {
        return values.contains(number);
    }

    @Override
    public String toString() {
        return String.valueOf(values);
    }
}
