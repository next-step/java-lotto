package step2.numbers;

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

    public boolean hasBonus(List<Number> userLotto) {
        return userLotto.contains(bonusNumber);
    }
}
