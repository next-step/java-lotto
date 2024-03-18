package model;

public class LottoResult {

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public LottoResult(final WinningNumbers winningNumbers, final BonusNumber bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(final WinningNumbers winningNumbers, final BonusNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber.getValue())) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 같으면 안 됩니다.");
        }
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumberValue() {
        return bonusNumber.getValue();
    }
}
