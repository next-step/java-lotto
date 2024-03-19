package lotto.domain.lotto.strategy;

import lotto.domain.lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.lotto.Lotto.*;

public class AutoGeneratingStrategy implements LottoGeneratingStrategy {
    @Override
    public Lotto lotto() {
        List<Integer> allLottoNumbers = new ArrayList<>();
        for (int number = MIN_LOTTO_NUMBER; number <= MAX_LOTTO_NUMBER; number++) {
            allLottoNumbers.add(number);
        }

        Collections.shuffle(allLottoNumbers);
        return Lotto.valueOf(allLottoNumbers.subList(0, LOTTO_NUMBER_SIZE));
    }
}
