package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomGenerator {

    private final List<Integer> numbers;

    public RandomGenerator() {
        numbers = new ArrayList<>();
        for (int number = LottoEnum.LOW_BOUND.value();
            number < LottoEnum.MAX_BOUND.value();
            number++) {
            numbers.add(number);
        }
    }

    public List<Integer> generate() {
        Collections.shuffle(numbers);
        List<Integer> result = new ArrayList<>(numbers.subList(0, 6));
        Collections.sort(result);
        return result;
    }
}
