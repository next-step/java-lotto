package study;

import exception.InvalidWinningNumberException;
import exception.LottoCountException;

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

    public static <T> void validateLottoNumberCount(List<T> numbers) {
        if (numbers.size() != LOTTO_NUMBERS) {
            throw new LottoCountException();
        }

        Set<Integer> distinctNumbers = new HashSet(numbers);

        if (distinctNumbers.size() != LOTTO_NUMBERS) {
            throw new LottoCountException();
        }
    }

    public static void validateLottoWinningNumber(List<Integer> numbers, int bonusNumber) {
        validateLottoNumberCount(numbers);

        if (numbers.contains(bonusNumber)) {
            throw new InvalidWinningNumberException();
        }
    }
}
