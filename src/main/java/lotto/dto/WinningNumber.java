package lotto.dto;

public class WinningNumber {
    private final String winningNumbers;
    private final int bonusNumber;

    public WinningNumber(String winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public String winningNumbers() {
        return winningNumbers;
    }

    public int bonusNumber() {
        return bonusNumber;
    }
}
