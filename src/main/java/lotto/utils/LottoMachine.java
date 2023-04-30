package lotto.utils;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int BEGIN_INDEX = 0;
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private List<LottoNumber> numbers;

    public LottoMachine() {
        this.numbers = initLottoNumbers();
    }

    public List<LottoNumber> drawnLottoNumbers() {
        Collections.shuffle(numbers);

        return numbers.subList(BEGIN_INDEX, BEGIN_INDEX + LOTTO_NUMBERS_SIZE);
    }

    public List<LottoNumber> initLottoNumbers() {
        List<LottoNumber> initLottoNumbers = new ArrayList<>();

        for (int i = LOTTO_NUMBER_MIN; i <= LOTTO_NUMBER_MAX; i++) {
            initLottoNumbers.add(new LottoNumber(i));
        }
        return initLottoNumbers;
    }
}

