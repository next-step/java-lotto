package step1.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperandValidatorTest {
    private final OperandValidator validator = new OperandValidator();

    @ParameterizedTest
    @NullAndEmptySource
    void nullAndEmpty(String given) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.countByExpression(given));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 + 1", "1 1 +"})
    void countByExpression(String given) {
        int actual = validator.countByExpression(given);
        int expected = 2;

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("숫자로 시작하지 않는 문자열은 예외를 던진다")
    @Test
    void countByExpressionThrowException() {
        String given = "+ 3 1";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.countByExpression(given));
    }
}
