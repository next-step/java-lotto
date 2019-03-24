package domain;

import java.util.Arrays;

public class WinningLotto {
    private int[] winningNumber;
    private int bonusNumber;

    public WinningLotto(String inputWinnigNumber, int bonusNumber) {
        this.winningNumber = convertToInt(inputWinnigNumber);
        this.bonusNumber = bonusNumber;
    }

    private int[] convertToInt(String inputWinningNumber) {
        String[] stringWinningNumbers = inputWinningNumber.replace(" ","").split(",");
        return Arrays.stream(stringWinningNumbers).mapToInt(str-> Integer.parseInt(str)).toArray();
    }

    public int[] getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
