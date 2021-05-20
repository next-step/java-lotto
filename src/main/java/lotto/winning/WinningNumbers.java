package lotto.winning;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private static final String SEPARATOR = ",";
    private static final String SEPARATOR_PATTERN = "^(([1-9]{1}|[1-3]{1}[0-9]{1}|[4]{1}[0-5]{1}),)+([1-9]{1}|[1-3]{1}[0-9]{1}|[4]{1}[0-5]{1})$";
    private static final String MATCH_PRICE = "^[0-9]+$";
    private static final String COMMA_MISS_EXCEPTION = "당첨번호는 쉼표(,)로 구분되어야합니다.";
    private static final String INPUT_WINNING_NUMBER_EXCEPTION = "당첨번호를 입력해주세요.";
    private static final String WINNING_NUMBER_DEFAULT_RANGE = "1 ~ 45 사이의 숫자만 입력해주세요.";
    private static final int MAX_WINNING_NUMBER_DIGIT = 6;
    private static final int MIN_LOTTO_RANGE = 0;
    private static final int MAX_LOTTO_RANGE = 45;

    List<Integer> winningNumbers;

    public WinningNumbers(String winningNumbers) {
        if (!isNullCheck(winningNumbers)) {
            throw new RuntimeException(INPUT_WINNING_NUMBER_EXCEPTION);
        }
        if (!winningNumbers.matches(SEPARATOR_PATTERN)) {
            throw new RuntimeException(COMMA_MISS_EXCEPTION);
        }

       this.winningNumbers = changeStringArrayToIntegerList(splitWinningNumbers(winningNumbers));
    }

    public boolean isNullCheck(String winningNumbers) {
        if (winningNumbers == null || winningNumbers.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean checkWinningNumbersRange(String numberString) {
        if (!numberString.matches(MATCH_PRICE)) {
            return false;
        }
        int number = Integer.parseInt(numberString);
        if (number < MIN_LOTTO_RANGE || number > MAX_LOTTO_RANGE) {
            return false;
        }
        return true;
    }

    public boolean checkWinningNumberDigit(int length) {
        if (length != MAX_WINNING_NUMBER_DIGIT) {
            return false;
        }
        return true;
    }

    public String[] splitWinningNumbers (String winningNumbers) {
        String[] numbers = winningNumbers.split(SEPARATOR);
        if (!checkWinningNumberDigit(numbers.length)) {
            throw new RuntimeException(INPUT_WINNING_NUMBER_EXCEPTION);
        }
        return numbers;
    }

    public List<Integer> changeStringArrayToIntegerList(String[] winningNumbers) {
        List<Integer> winningNumberList = new ArrayList<>();
        for (int i = 0; i < winningNumbers.length; i++) {
            if (!checkWinningNumbersRange(winningNumbers[i])) {
                throw new RuntimeException(WINNING_NUMBER_DEFAULT_RANGE);
            }
            winningNumberList.add(Integer.parseInt(winningNumbers[i]));
        }
        return winningNumberList;
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }
}
