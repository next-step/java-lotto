package lotto.domain;

import java.util.List;

public class LottoMachine {

    private final List<Integer> winNumbers;
    private final Integer bonusNumber;

    public LottoMachine(final List<Integer> winNumbers, final int bonusNumber) {
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean isContain(final int number) {
        return winNumbers.contains(number);
    }

    public boolean isEqualBonusNumber(final int number) {
        return bonusNumber.equals(number);
    }


}
