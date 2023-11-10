package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    @DisplayName("문자열 계산기 생성")
    void create() {
        StringCalculator stringCalculator = new StringCalculator("1");
        assertThat(stringCalculator).isInstanceOf(StringCalculator.class);
    }

    @Test
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 IllegalException 예외 발생")
    void add() {
        assertThatThrownBy(() -> new StringCalculator(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("덧셈")
    void add2() {
        StringCalculator stringCalculator = new StringCalculator("1,2");
        assertThat(stringCalculator.add(1, 2)).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈")
    void subtract() {
        StringCalculator stringCalculator = new StringCalculator("1,2");
        assertThat(stringCalculator.subtract(1, 2)).isEqualTo(-1);
    }

    @Test
    @DisplayName("곱셈")
    void multiply() {
        StringCalculator stringCalculator = new StringCalculator("1,2");
        assertThat(stringCalculator.multiply(1, 2)).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈")
    void divide() {
        StringCalculator stringCalculator = new StringCalculator("1,2");
        assertThat(stringCalculator.divide(1, 2)).isEqualTo(0);
    }
}
