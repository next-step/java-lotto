package lotto.model;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;

    private Set<Integer> numbers;

    public Lotto(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public Set<Integer> getNumbers() {
        return Collections.unmodifiableSet(this.numbers);
    }

    @Override
    public String toString() {
        return "[" +
                numbers.stream().map(v->v.toString()).collect(Collectors.joining(", "))+
                "]";
    }
}
