package lotto.model;

import java.util.List;

public class Lotto {

    private final List<Number> values;

    public Lotto(List<Number> values) {
        this.values = values;
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
