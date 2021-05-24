package step3.utils;

import java.util.List;

public class ValidationUtils {
    private static final String MATCH_PRICE = "^[0-9\\,]*$";
    private static final String WINNING_NUMBER_COMMA_EXCEPTION = "당첨번호는 쉼표(,)로 구분되어야합니다.";
    private static final String WINNING_NUMBER_NULL_EXCEPTION = "당첨번호를 입력해주세요.";
    private static final String WINNING_NUMBER_SIX_DIGIT_EXCEPTION = "당첨번호는 6자리 숫자로 구성되어야합니다.";

    private ValidationUtils() {
        throw new AssertionError();
    }

    public static boolean isNullCheck(String winningNumbers) {
        if (winningNumbers == null || winningNumbers.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean validWinningNumbersComma(String winningNumbers) {
        if (!winningNumbers.matches(MATCH_PRICE)) {
            return false;
        }
        return true;
    }

    public static boolean validWinningNumbersDigit(int size) {
        if (size != 6) {
            return false;
        }
        return true;
    }

    public static  List<Integer> validWinningNumbers(String winningNumbers) {
        if (!ValidationUtils.isNullCheck(winningNumbers)) {
            throw new RuntimeException(WINNING_NUMBER_NULL_EXCEPTION);
        }
        if (!ValidationUtils.validWinningNumbersComma(winningNumbers)) {
            throw new RuntimeException(WINNING_NUMBER_COMMA_EXCEPTION);
        }
        List<Integer> winningNumberList = StringUtils.processStringNumbers(winningNumbers);
        if (!ValidationUtils.validWinningNumbersDigit(winningNumberList.size())) {
            throw new RuntimeException(WINNING_NUMBER_SIX_DIGIT_EXCEPTION);
        }
        return winningNumberList;
    }
}
