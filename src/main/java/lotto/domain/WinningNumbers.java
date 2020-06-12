package lotto.domain;

import java.util.Set;

public class WinningNumbers {
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    private WinningNumbers(Set<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
//        validateBonusNumber(bonusNumber);
        validateDuplicateNumber(winningNumbers, bonusNumber);
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateNumber(Set<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스볼은 당첨번호와 중복될 수 없습니다.");
        }
    }

//    private void validateBonusNumber(LottoNumber bonusNumber) {
//        if (bonusNumber < Lotto.MIN_VALUE || bonusNumber > Lotto.MAX_VALUE) {
//            throw new IllegalArgumentException("보너스볼은 1 ~ 45 사이의 숫자로 구성 되어야 합니다.");
//        }
//    }

    public static WinningNumbers of(Set<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    public boolean hasNumber(LottoNumber number) {
        return winningNumbers.contains(number);
    }
}
