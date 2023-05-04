package lotto.step3.domain;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(int bonusNumber, WinningNumbers winningNumbers) {
        this.bonusNumber = validateBonusNumber(bonusNumber, winningNumbers);
    }

    public int validateBonusNumber(int bonusNumber, WinningNumbers winningNumbers) {
        if (winningNumbers.getWinningNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복될 수 없습니다. (입력된 보너스 값: " + bonusNumber + ")");
        }
        if (bonusNumber > 45 || bonusNumber < 0) {
            throw new IllegalArgumentException("보너스 볼 입력 범위는 1~45 입니다. (입력된 보너스 값: " + bonusNumber + ")");
        }
        return bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
