package step1.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.domain.CalculatorPolicy;
import step1.domain.Number;
import step1.domain.PlusCalculator;

class PlusCalculatorTest {

    @Test
    @DisplayName("Plus 계산기 생성 테스트")
    void plus_calculate_ctor_test() {
        assertThatNoException().isThrownBy(() -> new PlusCalculator(new Number(1)));
    }

    @Test
    @DisplayName("더하기 테스트")
    void plus_test() {
        //given
        CalculatorPolicy calculatorPolicy = new PlusCalculator(new Number(1));

        //when
        Number result = calculatorPolicy.calculate(new Number(5));

        //then
        assertThat(result).isEqualTo(new Number(6));
    }

}