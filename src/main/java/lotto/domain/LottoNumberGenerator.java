package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public static List<Integer> generate() {
        List<Integer> numbers = createNumbers();
        Collections.shuffle(numbers);
        return selectNumbers(numbers);
    }

    private static List<Integer> createNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    private static List<Integer> selectNumbers(List<Integer> numbers) {
        return new ArrayList<>(numbers.subList(0, 6));
    }
}
