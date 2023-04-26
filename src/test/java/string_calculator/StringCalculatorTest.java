package string_calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringCalculatorTest {
    @ParameterizedTest(name = "{0}이 주어지면 결과는 {1}이다.")
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "1 + 3:4", "5 - 2 / 3:1", "6 * 2 * 4:48", "3 + 3 + 3 + 1 / 3:3"}, delimiter = ':')
    void 문자열로_주어진_사칙연산을_할_수_있다(String input, int expected) {
        assertThat(StringCalculator.splitAndCalculate(input)).isEqualTo(expected);
    }

    @Test
    void 입력_값이_null이면_예외가_발생한다() {
        assertThatThrownBy(() -> StringCalculator.splitAndCalculate(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_값이_공백이면_예외가_발생한다() {
        assertThatThrownBy(() -> StringCalculator.splitAndCalculate("")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}이 주어지면 예외가 발생한다")
    @ValueSource(strings = {"2+3 * 4 / 2", "1 +3", "5 - 2 // 3", "6 * 2 * 4 가", "3 3 3 3 3 + 1"})
    void 알맞지_않은_입력이_주어지면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> StringCalculator.splitAndCalculate(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
