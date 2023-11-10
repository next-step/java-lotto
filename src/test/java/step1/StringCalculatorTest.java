package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    private final String COMMON_INPUT = "2 + 3 * 4 / 2";
    @Test
    @DisplayName("문자열 계산기 생성")
    void create() {
        StringCalculator stringCalculator = new StringCalculator("1");
        assertThat(stringCalculator).isInstanceOf(StringCalculator.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 IllegalException 예외 발생")
    void add(String input) {
        assertThatThrownBy(() -> new StringCalculator(null))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new StringCalculator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자와 사칙연산 기호 이외의 문자가 포함된 경우 IllegalException 예외 발생")
    void inputCheck() {
        assertThatThrownBy(() -> new StringCalculator("13,2,3,4,5,6,7,8,9,0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("덧셈")
    void add2() {
        StringCalculator stringCalculator = new StringCalculator(COMMON_INPUT);
        assertThat(stringCalculator.add(1, 2)).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈")
    void subtract() {
        StringCalculator stringCalculator = new StringCalculator(COMMON_INPUT);
        assertThat(stringCalculator.subtract(1, 2)).isEqualTo(-1);
    }

    @Test
    @DisplayName("곱셈")
    void multiply() {
        StringCalculator stringCalculator = new StringCalculator(COMMON_INPUT);
        assertThat(stringCalculator.multiply(1, 2)).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈")
    void divide() {
        StringCalculator stringCalculator = new StringCalculator(COMMON_INPUT);
        assertThat(stringCalculator.divide(1, 2)).isEqualTo(0);
    }

}
