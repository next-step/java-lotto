package calculator;

import calculator.domain.Number;
import calculator.domain.OperatorType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperatorTypeTest {

    private Number number1, number2;

    @BeforeEach
    void before() {
        number1 = new Number("4");
        number2 = new Number("2");
    }

    @Test
    void 덧셈() {
        assertThat(OperatorType.PLUS.calculate(number1, number2)).isEqualTo(6);
    }

    @Test
    void 뺄셈() {
        assertThat(OperatorType.MINUS.calculate(number1, number2)).isEqualTo(2);
    }

    @Test
    void 곱셈() {
        assertThat(OperatorType.MULTIPLY.calculate(number1, number2)).isEqualTo(8);
    }

    @Test
    void 나눗셈() {
        assertThat(OperatorType.DIVIDE.calculate(number1, number2)).isEqualTo(2);
    }

    @Test
    void 사칙연산_아닌경우_예외처리() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> OperatorType.of("1"))
                .withMessageContaining("사칙연산 기호가 아닙니다.");
    }
}
