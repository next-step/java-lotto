package calculator.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorValidatorTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 10})
    @DisplayName("음수가 아닌 경우 정상처리")
    void checkLessThanZero(int number) {
        StringAddCalculatorValidator.checkLessThanZero(number);
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다")
    void checkLessThanZeroException() {
        assertThatThrownBy(() -> StringAddCalculatorValidator.checkLessThanZero(-1))
                .isInstanceOf(RuntimeException.class);
    }
}
