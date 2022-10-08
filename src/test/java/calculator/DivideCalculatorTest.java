package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivideCalculatorTest {
    @Test
    void 나눗셈의_경우_정수로_덜어지지_않으면_에러_발생() {
        Calculator calculator = new DivideCalculator();
        Assertions.assertThatThrownBy(() -> calculator.calculate(3, 2))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("나눗셈의 결과가 정수가 아닙니다.");
    }
}