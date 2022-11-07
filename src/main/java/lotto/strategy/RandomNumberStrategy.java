package lotto.strategy;

import lotto.domain.LottoNumbers;

import java.util.Collections;
import java.util.List;

public class RandomNumberStrategy implements LottoNumberStrategy {

    private static final int MIN_IDX = 0;
    private static final int CNT = 6;
    private static final List<Integer> numbers = LottoNumbers.getLottoNumbers();

    @Override
    public List<Integer> getNumbers() {
        Collections.shuffle(numbers);
        return numbers.subList(MIN_IDX, CNT);
    }
}
