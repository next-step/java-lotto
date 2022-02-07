package lotto.domain;

public class CorrectNumbers {

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public CorrectNumbers(final WinningNumbers winningNumbers, final BonusNumber bonusNumber) {
        validateDuplicateNumber(winningNumbers, bonusNumber);

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateNumber(final WinningNumbers winningNumbers,
            final BonusNumber bonusNumber) {
        if (winningNumbers.get().contains(bonusNumber.get())) {
            throw new IllegalArgumentException("로또 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
