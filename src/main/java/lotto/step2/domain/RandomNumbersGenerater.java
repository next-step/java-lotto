package lotto.step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumbersGenerater implements LottoNumbersGenerater {
    private static final int LIMIT_LOTTO_NUMBER = 45;
    private static final int LIMIT_LOTTO_COUNT = 6;

    @Override
    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i < LIMIT_LOTTO_NUMBER; i++){
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, LIMIT_LOTTO_COUNT);
    }
}
