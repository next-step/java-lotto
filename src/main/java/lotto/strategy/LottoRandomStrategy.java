package lotto.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoRandomStrategy implements LottoNumberStrategy {
    static public final int VALUE_MIN_LOTTO = 1;
    static public final int VALUE_MAX_LOTTO = 45;
    static public final int LOTTO_MAX_COUNT = 6;

    @Override
    public List<Integer> generate() {
        List<Integer> numbers = getOrderedNumbers();

        Collections.shuffle(numbers);

        return numbers.subList(0, LOTTO_MAX_COUNT);
    }

    private List<Integer> getOrderedNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = VALUE_MIN_LOTTO; i <= VALUE_MAX_LOTTO; i++) {
            numbers.add(i);
        }

        return numbers;
    }
}
