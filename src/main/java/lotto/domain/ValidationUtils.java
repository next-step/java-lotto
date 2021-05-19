package lotto.domain;

import java.util.List;

public class ValidationUtils {

    public static final int LOTTO_NUMBERS_LENGTH = 6;

    public static boolean isValidPrice(int price) {
        return price >= 1000;
    }

    public static boolean isValidLottoNumberBoundary(int number) {
        return number >= 1 && number <= 45;
    }

    public static boolean isValidLottoNumbersLength(List<Integer> numbers) {
        return numbers != null && numbers.size() == LOTTO_NUMBERS_LENGTH;
    }
}
