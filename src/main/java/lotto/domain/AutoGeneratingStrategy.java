package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.Lotto.*;

public class AutoGeneratingStrategy implements LottoNumberGeneratingStrategy {
    private static final List<Integer> ALL_LOTTO_NUMBERS = allLottoNumbers();

    private static List<Integer> allLottoNumbers() {
        List<Integer> numberList = new ArrayList<>();
        for (int number = MIN_LOTTO_NUMBER; number <= MAX_LOTTO_NUMBER; number++) {
            numberList.add(number);
        }

        return numberList;
    }

    @Override
    public List<Integer> lottoNumbers() {
        Collections.shuffle(ALL_LOTTO_NUMBERS);
        return ALL_LOTTO_NUMBERS.subList(0, LOTTO_NUMBER_COUNT);
    }
}
