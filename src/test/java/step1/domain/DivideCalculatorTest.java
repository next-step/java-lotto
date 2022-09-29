package step1.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DivideCalculatorTest {

    @Test
    @DisplayName("나누기 생성 테스트")
    void divide_ctor_test() {
        assertThatNoException().isThrownBy(() -> new DivideCalculator(new Number(5)));
    }

    @Test
    @DisplayName("나누기 테스트")
    void divide_test() {
        //given
        CalculatorPolicy calculatorPolicy = new DivideCalculator(new Number(5));

        //when
        Number result = calculatorPolicy.calculate(new Number(1));

        //then
        assertThat(result).isEqualTo(new Number(5));
    }

    @Test
    @DisplayName("0으로 나눌 시 예외가 발생한다.")
    void zero_divide_throw_exception() {
        //given
        CalculatorPolicy calculatorPolicy = new DivideCalculator(new Number(5));

        //then
        assertThatThrownBy(() -> calculatorPolicy.calculate(new Number(0)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("0으로 나눌 수 없습니다.");
    }
}