package study.step1;

import org.junit.jupiter.api.Test;
import study.step1.domain.exception.CalculatorException;
import study.step1.domain.type.Operator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class OperatorTest {

    @Test
    void 더하기() {
        assertThat(Operator.PLUS.calculate(1, 2)).isEqualTo(3);
    }

    @Test
    void 빼기() {
        assertThat(Operator.MINUS.calculate(1, 2)).isEqualTo(-1);
    }

    @Test
    void 곱하기() {
        assertThat(Operator.TIMES.calculate(1, 2)).isEqualTo(2);
    }

    @Test
    void 나누기() {
        assertThat(Operator.DIVIDE.calculate(1, 2)).isEqualTo(0);
        assertThat(Operator.DIVIDE.calculate(2, 2)).isEqualTo(1);
    }

    @Test
    void 나누기오류() {
        assertThatExceptionOfType(CalculatorException.class)
            .isThrownBy(() -> Operator.DIVIDE.calculate(1, 0))
            .withMessage("DivideError: 0으로는 나눌 수 없습니다.");
    }

}
