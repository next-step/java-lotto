package lotto.dto;

import lotto.domain.Lotto;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static lotto.service.helper.LottoFactory.PRICE_OF_ONE_LOTTO;

public class ManualLottoNumbers {
    private final List<Set<Integer>> manualNumbers;

    public ManualLottoNumbers(List<Set<Integer>> manualNumbers) {
        this.manualNumbers = manualNumbers;
    }

    public static ManualLottoNumbers empty() {
        return new ManualLottoNumbers(Collections.emptyList());
    }

    public int addManualLottos(List<Lotto> lottos, int amount) {
        for (Set<Integer> manualLottoNumber : manualNumbers) {
            lottos.add(Lotto.of(manualLottoNumber));
            amount -= PRICE_OF_ONE_LOTTO;
        }

        return amount;
    }

    public int size() {
        return manualNumbers.size();
    }
}
