package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class ValidationUtils {

    public static final int LOTTO_NUMBERS_LENGTH = 6;
    public static final int MINIMUM_PRICE = 1000;
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;

    public static boolean isValidPrice(int price) {
        return price >= MINIMUM_PRICE;
    }

    public static boolean isValidLottoNumberBoundary(int number) {
        return number >= MINIMUM_NUMBER && number <= MAXIMUM_NUMBER;
    }

    public static boolean isValidLottoNumbersLength(List<Integer> numbers) {
        return numbers != null && numbers.size() == LOTTO_NUMBERS_LENGTH;
    }

    public static boolean isNotDuplicateNumbers(List<Integer> numbers) {
        return new HashSet<>(numbers).size() == LOTTO_NUMBERS_LENGTH;
    }
}
