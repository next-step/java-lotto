package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_NUMBER_BOUND = 45;

    public static List<Integer> createLottoNumbers() {
        List<Integer> numbers = new ArrayList<Integer>();
        for (int bound = 1; bound <= LOTTO_NUMBER_BOUND; bound++) {
            numbers.add(bound);
        }
        Collections.shuffle(numbers);
        numbers = numbers.subList(0, LOTTO_NUMBER_COUNT);

        Collections.sort(numbers);
        return numbers;
    }
}
