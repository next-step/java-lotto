package lotto.domain.lotto.strategy;

import lotto.domain.lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.lotto.Lotto.*;

public class AutoGeneratingStrategy implements LottoGeneratingStrategy {
    private static final List<Integer> ALL_LOTTO_NUMBERS = allLottoNumbers();

    private static List<Integer> allLottoNumbers() {
        List<Integer> allLottoNumbers = new ArrayList<>();
        for (int number = MIN_LOTTO_NUMBER; number <= MAX_LOTTO_NUMBER; number++) {
            allLottoNumbers.add(number);
        }

        return allLottoNumbers;
    }

    @Override
    public Lotto lotto() {
        Collections.shuffle(ALL_LOTTO_NUMBERS);
        return Lotto.valueOf(ALL_LOTTO_NUMBERS.subList(0, LOTTO_NUMBER_SIZE));
    }
}
