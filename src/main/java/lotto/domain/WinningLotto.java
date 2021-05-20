package lotto.domain;

public class WinningLotto {

    private final LottoNumbers winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        validateDuplicate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 로또번호와 중복될 수 없습니다.");
        }
    }

    public WinningType matchWinning(Lotto lotto) {
        return lotto.match(winningNumbers, bonusNumber);
    }
}
