package step1.validator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperatorValidatorTest {
    private final OperatorValidator validator = new OperatorValidator();

    @ParameterizedTest
    @NullAndEmptySource
    void nullAndEmpty(String given) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.countByExpression(given));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 + 2", "2 - 3", "3 * 4", "4 / 5"})
    void countByExpression(String given) {
        int actual = validator.countByExpression(given);
        int expected = 1;
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 ^ 2", "2 ! 3", "3 AND 4", "4 % 5", "5 || 6", "6 OR 7"})
    void invalidOperator(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.countByExpression(input));
    }

}
