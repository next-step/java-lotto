package lotto.view;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ValidatorUtils {

    private ValidatorUtils() {}

    public static void assertValidation(Validator validator, String input, String message) {
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validate(input))
                .withMessage(message);
    }
}
