package lotto.model;

public class DrawNumbers {
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public DrawNumbers(Lotto winningNumbers, LottoNumber bonusNumber) {
        validateUnique(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateUnique(Lotto winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호가 중복 되었습니다.");
        }
    }

    Lotto getWinningNumbers() {
        return winningNumbers;
    }

    LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
