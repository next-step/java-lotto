package lotto.domain;

import java.util.HashSet;
import java.util.List;

import static lotto.domain.LottoNumber.MAXIMUM_NUMBER;
import static lotto.domain.LottoNumber.MINIMUM_NUMBER;
import static lotto.domain.LottoTicket.LOTTO_NUMBERS_LENGTH;

public class ValidationUtils {

    public static final int MINIMUM_PRICE = 1000;

    public static boolean isValidPrice(int price) {
        return price >= MINIMUM_PRICE;
    }

    public static boolean isValidLottoNumberBoundary(int number) {
        return number >= MINIMUM_NUMBER && number <= MAXIMUM_NUMBER;
    }

    public static boolean isNotDuplicateNumbers(List<Integer> numbers) {
        return new HashSet<>(numbers).size() == LOTTO_NUMBERS_LENGTH;
    }
}
