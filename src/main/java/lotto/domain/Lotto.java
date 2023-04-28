package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public List<Integer> numbers = new ArrayList<>(LottoRule.NUMBER_RANGE);

    public Lotto() {
        Collections.shuffle(numbers);
        numbers = numbers.subList(0, LottoRule.CHOICE_COUNT);
        Collections.sort(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
