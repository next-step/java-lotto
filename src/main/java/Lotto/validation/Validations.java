package Lotto.validation;

import Lotto.utils.ValidationUtils;

import java.util.Arrays;

import static Lotto.domain.Lottos.*;
import static Lotto.domain.Purchase.UNIT;

public class Validations {
    public static boolean isInvalidWinningNumbers(String input) {
        String[] numbers = input.split(",");
        return numbers.length != LOTTO_PICK_COUNT ||
                Arrays.stream(numbers).anyMatch(number -> ValidationUtils.isInvalidNumber(number, LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER));
    }

    public static boolean isInvalidPrice(String input) {
        String sanitizedInput = input.replace(",", "");
        return ValidationUtils.isInvalidNumber(sanitizedInput, UNIT, Integer.MAX_VALUE) ||
                Integer.parseInt(sanitizedInput) % UNIT != 0;
    }
}
