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
    void 정규식으로_연산자의_개수를_구한다(String given) {
        int actual = validator.countByExpression(given);
        int expected = 1;
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 ^ 2", "2 ! 3", "3 AND 4", "4 % 5", "5 || 6", "6 OR 7"})
    void 문자열에_사칙연산자를_제외한_기호는_예외를_던진다(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.countByExpression(input));
    }

}
