package stringCalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringValidatorTest {
    private StringValidator stringValidator = new StringValidator();

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2", "2 + 3"})
    void inputValidate(String input) {
        assertTrue(stringValidator.validate(input));
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"2 + 3 * 4/ 2", "", "2 + 3 /", ""})
    void inputInvalidate(String input) {
        assertThrows(IllegalArgumentException.class, () -> stringValidator.validate(input));
    }
}
