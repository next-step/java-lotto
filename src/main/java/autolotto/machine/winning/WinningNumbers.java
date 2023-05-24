package autolotto.machine.winning;

import autolotto.machine.lotto.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        checkBonusIsDuplicatedNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void checkBonusIsDuplicatedNumber(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public List<LottoNumber> winningNumbers() {
        return new ArrayList<>(this.winningNumbers);
    }

    public LottoNumber bonusNumber() {
        return this.bonusNumber;
    }
}
