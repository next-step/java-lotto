package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }

    @Override
    public String toString() {
        return "[" +
                numbers.stream().map(v->v.toString()).collect(Collectors.joining(", "))+
                "]";
    }
}
