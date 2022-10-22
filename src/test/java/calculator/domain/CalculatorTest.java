package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CalculatorTest {

    @Test
    void 계산식을_확인한다() {
        Calculator mapper = Calculator.from("2 + 3 * 4 / 2");

        assertThat(mapper.execute()).isEqualTo(10);
    }

    @Test
    void 계산식의_시작이_숫자가_아닐_경우를_확인한다() {
        Calculator mapper = Calculator.from("+ 3 * 4 / 2");

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(mapper::execute);
    }
}