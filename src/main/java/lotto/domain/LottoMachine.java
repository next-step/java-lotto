package lotto.domain;

import java.util.List;

public class LottoMachine {

    private final List<Integer> winNumbers;
    private final int bonusNumber;

    public LottoMachine(List<Integer> winNumbers, int bonusNumber) {
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }
}
