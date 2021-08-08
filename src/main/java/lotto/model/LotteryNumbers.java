package lotto.model;

public class LotteryNumbers {
    private final WinningNumbers winningNumbers;
    private final LottoNumber bonusNumber;

    public LotteryNumbers(WinningNumbers winningNumbers, LottoNumber bonusNumber) {
        validateUnique(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateUnique(WinningNumbers winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호가 중복 되었습니다.");
        }
    }

    WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
