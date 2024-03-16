package step1.validator;

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
    void 정규식으로_숫자_개수를_구한다(String given) {
        int actual = validator.countByExpression(given);
        int expected = 2;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 숫자로_시작하지_않는_문자열은_예외를_던진다() {
        String given = "+ 3 1";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.countByExpression(given));
    }
}
