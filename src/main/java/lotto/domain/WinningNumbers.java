package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    private WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = Lotto.of(winningNumbers);
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    public static WinningNumbers of(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨번호와 같을 수 없습니다.");
        }
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    public int numberOfSame(Lotto lotto) {
        return winningNumbers.numberOfSame(lotto);
    }

    public boolean isSameBonus(Lotto lotto) {
        return lotto.isSameNumber(bonusNumber);
    }
}
