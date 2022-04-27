package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {
    @ParameterizedTest()
    @CsvSource(value = {"10 + 10 - 7 * 2:26", "1 + 1:2"}, delimiter = ':')
    void 정상적인_동작(String input, int expected) {
        assertThat(StringCalculator.calculator(input)).isEqualTo(expected);
    }

    @Test
    void 이상한_연산자가_들어온다() {
        assertThatThrownBy(() -> StringCalculator.calculator("1 & 1"))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("정의되지 않은 연산자가 입력 되었습니다.");
    }

    @Test
    void _0_으로_나눌수는_없다() {
        assertThatThrownBy(() -> StringCalculator.calculator("1 / 0"))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("0으로 나눌 수 없습니다.");
    }
}
