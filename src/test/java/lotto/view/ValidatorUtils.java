package lotto.view;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ValidatorUtils {

    private ValidatorUtils() {}

    public static void assertValidation(Validator validator, String input, String message) {
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validate(input))
                .withMessage(message);
    }

    public static void assertDoesNotThrow(Validator validator, String input) {
        assertThatCode(() -> validator.validate(input)).doesNotThrowAnyException();
    }
}
