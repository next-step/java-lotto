package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {

    @DisplayName("사칙연산 아닐경우   -> IllegalArgumentException throw")
    @Test
    void not_사칙연산() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new Calculator().calculate("1 @ 3");
                })
                .withMessage("%s!", "사칙연산으로만 계산이 가능합니다")
                .withNoCause();

    }

    @DisplayName("입력 null,빈 공백 -> IllegalArgumentException throw")
    @Test
    void null_blank() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new Calculator().calculate(" ");
                })
                .withMessage("%s!", "공백은 계산처리가 안됩니다")
                .withNoCause();

    }

    @DisplayName("문자열 계산기에 문자열을 입력하면 정수값이 출력된다")
    @ParameterizedTest
    @CsvSource(value = {"1 + 3 - 3:1", "1 + 3 - 3 * 3:3", "1 + 3 - 3 * 3 / 3:1"}, delimiter = ':')
    void string_cal_test(String input, int expected) {
        assertThat(new Calculator().calculate(input)).isEqualTo(expected);
    }

    @DisplayName("덧셈")
    @Test
    void add() {
        String input = "1 + 3";
        assertThat(new Calculator().calculate(input)).isEqualTo(4);
    }

    @DisplayName("뺄셈")
    @Test
    void minus() {
        String input = "1 - 3";
        assertThat(new Calculator().calculate(input)).isEqualTo(-2);
    }

    @DisplayName("곱셈")
    @Test
    void multiply() {
        String input = "1 * 3";
        assertThat(new Calculator().calculate(input)).isEqualTo(3);
    }

    @DisplayName("나눗셈")
    @Test
    void divide() {
        String input = "1 / 3";
        assertThat(new Calculator().calculate(input)).isEqualTo(0);
    }

}
