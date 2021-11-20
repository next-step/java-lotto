package lotto.utils;

import addcalculator.exception.NotInstanceException;
import lotto.domain.value.TicketCount;
import lotto.exception.EmptySourceException;
import lotto.exception.InvalidValueException;

import java.util.Objects;

public class InputUtils {

    private InputUtils() {
        throw new NotInstanceException();
    }

    public static TicketCount createLottoCount(String input) {
        validate(input);
        return TicketCount.of(input);
    }

    private static void validate(String input) {
        validateEmpty(input);
        validateIsDigit(input);
    }

    private static void validateEmpty(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new EmptySourceException();
        }
    }

    private static void validateIsDigit(String input) {
        boolean isDigit = input.chars()
                .allMatch(Character::isDigit);

        if (!isDigit) {
            throw new InvalidValueException();
        }
    }
}
