package me.devyonghee.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

import static org.assertj.core.api.Assertions.*;

@DisplayName("계산기 팩토리")
class CalculatorFactoryTest {

    @Test
    @DisplayName("객체화 불가능")
    void instance_thrownAssertionError() {
        assertThatExceptionOfType(AssertionError.class)
                .isThrownBy(() -> ReflectionUtils.newInstance(CalculatorFactory.class));
    }

    @Test
    @DisplayName("계산기 생성")
    void calculator() {
        assertThat(CalculatorFactory.calculator(Operation.PLUS, () -> Number.ONE, Number.ONE))
                .isInstanceOf(PlusCalculator.class);
        assertThat(CalculatorFactory.calculator(Operation.MINUS, () -> Number.ONE, Number.ONE))
                .isInstanceOf(MinusCalculator.class);
        assertThat(CalculatorFactory.calculator(Operation.DIVIDE, () -> Number.ONE, Number.ONE))
                .isInstanceOf(DivideCalculator.class);
        assertThat(CalculatorFactory.calculator(Operation.PLUS, () -> Number.ONE, Number.ONE))
                .isInstanceOf(PlusCalculator.class);
    }

    @Test
    @DisplayName("연산 종류는 필수")
    void calculator_nullOperation_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> CalculatorFactory.calculator(null, () -> Number.ONE, Number.ONE));
    }
}
