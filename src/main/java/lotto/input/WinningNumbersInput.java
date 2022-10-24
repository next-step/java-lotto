package lotto.input;

public class WinningNumbersInput {
    private final String winningNumberString;
    private final String bonusWinningNumberString;

    public WinningNumbersInput(String winningNumberString, String bonusWinningNumberString) {
        this.winningNumberString = winningNumberString;
        this.bonusWinningNumberString = bonusWinningNumberString;
    }

    public String getWinningNumberString() {
        return winningNumberString;
    }

    public String getBonusWinningNumberString() {
        return bonusWinningNumberString;
    }
}
