package step1.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.domain.CalculatorPolicy;
import step1.domain.MultipleCalculator;
import step1.domain.Number;

public class MultipleCalculatorTest {

    @Test
    @DisplayName("곱하기 생성 테스트")
    void multiple_ctor_test() {
        assertThatNoException().isThrownBy(() -> new MultipleCalculator(new Number(5)));
    }

    @Test
    @DisplayName("곱하기 테스트")
    void multiple_calculate_test() {
        //given
        CalculatorPolicy calculatorPolicy = new MultipleCalculator(new Number(1));

        //when
        Number result = calculatorPolicy.calculate(new Number(5));

        //then
        assertThat(result).isEqualTo(new Number(5));
    }
}
