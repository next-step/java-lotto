package lotto.domain;

import static lotto.domain.LottoNumbers.*;

public class WinningNumber {

    private static final String INPUT_WINNING_NUMBER_DELIMITER = ", ";
    public static final String INVALID_WINNING_NUMBER_SIZE = "6개의 당첨번호를 입력해주세요.";

    public String[] setWinningNumber(String winningNumber) {
        String[] winningNumbers = winningNumber.split(INPUT_WINNING_NUMBER_DELIMITER);
        invalidWinningNumberSizeException(winningNumbers);
        return winningNumbers;
    }

    public void invalidWinningNumberSizeException(String[] winningNumbers) {
        if (winningNumbers.length != 6) {
            throw new RuntimeException(INVALID_WINNING_NUMBER_SIZE);
        }
    }

    public void winningNumberRangeException(String[] winningNumbers) {
        for (String number : winningNumbers) {
            int winnungNumber = Integer.parseInt(number);
            winningNumberRangeCheck(winnungNumber);
        }
    }

    private void winningNumberRangeCheck(int number) {
        if (number > LOTTO_BASE_END_NUMBER || number < LOTTO_BASE_START_NUMBER) {
            throw new RuntimeException(INVALID_LOTTO_NUMBER);
        }
    }

}
