package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CalculatorTest {

        @ParameterizedTest
        @NullAndEmptySource
        void 입력_값이_null_또는_빈_공백이면_에러(String input) {
                Calculator calculator = new Calculator();
                assertThatThrownBy(() -> calculator.calculate(input)).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 사칙연산_기호가_아니면_에러() {
                Calculator calculator = new Calculator();
                assertThatThrownBy(() -> calculator.calculate("1 @ 3")).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 사칙연산_실행() {
                Calculator calculator = new Calculator();
                assertThat(calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
        }
}
