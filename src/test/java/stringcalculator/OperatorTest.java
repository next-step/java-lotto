package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorTest {
    @Test
    void 덧셈() {
        assertThat(Operator.PLUS.mapCalculate(3,6)).isEqualTo(9);
    }

    @Test
    void 뺄셈() {
        assertThat(Operator.MINUS.mapCalculate(8,3)).isEqualTo(5);
    }

    @Test
    void 곱셈() {
        assertThat(Operator.MULTIPLY.mapCalculate(3,7)).isEqualTo(21);
    }

    @Test
    void 나눗셈() {
        assertThat(Operator.DIVIDE.mapCalculate(9,3)).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"%", "#", "@"})
    @DisplayName("사칙연산 기호가 아닌 경우 예외 발생")
    void 사칙연산_기호_아닌경우(String operator) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operator.getExpression(operator);
        });
    }

}