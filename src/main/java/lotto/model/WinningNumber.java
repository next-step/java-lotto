package lotto.model;

public class WinningNumber {

    private LottoNumbers winningNumbers;
    private Number bonusBall;

    public WinningNumber(LottoNumbers winningNumbers, Number bonusBall) {
        validate(winningNumbers, bonusBall);
        this.winningNumbers = winningNumbers;
        this.bonusBall = bonusBall;
    }

    private void validate(LottoNumbers winningNumbers, Number bonusBall) {
        if (winningNumbers.hasNumber(bonusBall)) {
            throw new IllegalArgumentException("보너스 볼과 당첨 번호는 중복 될 수 없습니다.");
        }
    }

    LottoNumbers getWinningNumbers() {
        return winningNumbers;
    }

    Number getBonusBall() {
        return bonusBall;
    }
}
