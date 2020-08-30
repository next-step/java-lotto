package lotto.domain;

public class WinningNumbers {
    private static String[] winningNumbers;

    public WinningNumbers(String[] winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static String[] getWinningNumbers() {
        return winningNumbers;
    }
}
