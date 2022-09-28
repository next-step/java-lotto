package step1.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.domain.CalculatorPolicy;
import step1.domain.DivideCalculator;
import step1.domain.Number;

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
}