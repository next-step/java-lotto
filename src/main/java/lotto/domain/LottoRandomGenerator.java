package lotto.domain;

import lotto.strategy.LottoGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRandomGenerator implements LottoGenerator {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    @Override
    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();

        for (int number = MIN_LOTTO_NUMBER; number <= MAX_LOTTO_NUMBER; number++) {
            numbers.add(number);
        }
        Collections.shuffle(numbers);

        return numbers.subList(0, LOTTO_NUMBER_COUNT);
    }

}
