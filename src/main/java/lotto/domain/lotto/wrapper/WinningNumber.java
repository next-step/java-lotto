package lotto.domain.lotto.wrapper;

import java.util.Set;

public class WinningNumber {

    private final LottoNumbers winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumber(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        validateBonusNumber(winningNumbers, bonusNumber);

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningNumber(Set<Integer> winningNumbers, int bonusNumber) {
        this(new LottoNumbers(winningNumbers), LottoNumber.of(bonusNumber));
    }

    private void validateBonusNumber(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨번호와 중복될 수 없습니다.");
        }
    }

    public boolean containsBonus(LottoNumbers lotto) {
        return lotto.contains(bonusNumber);
    }

    public int countMatchingNumbers(LottoNumbers lottoNumbers) {
        return winningNumbers.countMatchingNumbers(lottoNumbers);
    }
}
