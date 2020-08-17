package study;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidateUtil {
    public static final int LOTTO_NUMBERS = 6;
    public static final String INVALID_WINNING_NUMBERS_MESSAGE = "Invalid Winning numbers count";

    private ValidateUtil() {
    }

    public static boolean validateEmptyExpression(String expression) {
        return expression == null || expression.isEmpty();
    }

    public static void valdateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBERS) {
            throw new RuntimeException(INVALID_WINNING_NUMBERS_MESSAGE);
        }

        Set<Integer> distinctWinningNumbers = new HashSet(winningNumbers);

        if (distinctWinningNumbers.size() != LOTTO_NUMBERS) {
            throw new RuntimeException(INVALID_WINNING_NUMBERS_MESSAGE);
        }
    }
}
