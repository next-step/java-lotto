package lotto.utils;

import java.util.Collections;
import java.util.List;

import static lotto.domain.LottoNumber.allNumbers;

public class LottoMachine {

    private static final int BEGIN_INDEX = 0;
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public LottoMachine() {
        this.numbers = allNumbers;
    }

    public List<Integer> drawnLotto() {
        Collections.shuffle(numbers);

        return numbers.subList(BEGIN_INDEX, LOTTO_SIZE);
    }
}
