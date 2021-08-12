package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean contains(final int number) {
        return numbers.contains(number);
    }

    public int countSameNumber(final Lotto lotto) {
        List<Integer> tempNumbers = new ArrayList<>(numbers);
        tempNumbers.retainAll(lotto.value());
        return tempNumbers.size();
    }

    public List<Integer> value() {
        return numbers;
    }
}
