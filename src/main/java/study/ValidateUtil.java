package study;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidateUtil {
    public static final int LOTTO_NUMBERS = 6;

    private ValidateUtil() {
    }

    public static boolean validateEmptyExpression(String expression) {
        return expression == null || expression.isEmpty();
    }

    public static boolean valdateWinningNumbers(List<Integer> winningNumbers) {
        Set<Integer> numbers = new HashSet(winningNumbers);

        return numbers.size() == LOTTO_NUMBERS;
    }
}
