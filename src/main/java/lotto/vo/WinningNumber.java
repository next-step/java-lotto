package lotto.vo;

public class WinningNumber {
    public static final String FORMAT_COMMA = ",";
    String[] winningNumbers;

    public WinningNumber(String inputNumber) {
        winningNumbers = inputNumber.split(FORMAT_COMMA);
    }

    public int getWinningNumbersSize(){
        return winningNumbers.length;
    }
}
