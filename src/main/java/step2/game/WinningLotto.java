package step2.game;

import java.util.List;

public class WinningLotto {
    private WinningNumbers numbers;
    private Number bonusNumber;

    public WinningLotto(String inputNumbers, int bonusNumber) {
        WinningNumbers winningNumbers = new WinningNumbers(inputNumbers);
        winningNumbers.verifyLottoNumberOrBonusNumber(bonusNumber);
        this.numbers = winningNumbers;
        this.bonusNumber = Number.valueOf(bonusNumber);
    }

    public boolean contains(Number integer) {
        return numbers.contains(integer);
    }

    boolean hasBonus(List<Number> userLotto) {
        return userLotto.contains(bonusNumber);
    }
}
