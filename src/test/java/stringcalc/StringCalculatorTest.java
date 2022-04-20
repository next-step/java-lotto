package stringcalc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    @Test
    void createTest() {
        StringCalculator stringCalculator = new StringCalculator();

        assertThat(stringCalculator).isNotNull();
    }

    @DisplayName("정상 예시 동작한다.")
    @Test
    void executeTest0() {
        StringCalculator stringCalculator = new StringCalculator();

        int result = stringCalculator.execute("4 / 2 * 2 + 3");

        assertThat(result).isEqualTo(7);
    }

    @DisplayName("정상 예시 동작한다.")
    @Test
    void executeTest1() {
        StringCalculator stringCalculator = new StringCalculator();

        int result = stringCalculator.execute("2 + 3 * 4 / 2");

        assertThat(result).isEqualTo(10);
    }

    @DisplayName("계산에 유효하지 않은 문자열은 예외 발생한다.")
    @Test
    void executeTest2() {
        StringCalculator stringCalculator = new StringCalculator();

        assertThatThrownBy(() -> stringCalculator.execute("2 + 3 * 4 / "))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정수가 있어야 할 자리에 정수가 아니면 예외 발생한다.")
    @Test
    void executeTest3() {
        StringCalculator stringCalculator = new StringCalculator();

        assertThatThrownBy(() -> stringCalculator.execute("- 3 3 * 4 / "))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사칙연산 기호가 있어야 할 자리에 기호가 아니면 예외 발생한다.")
    @Test
    void executeTest4() {
        StringCalculator stringCalculator = new StringCalculator();

        assertThatThrownBy(() -> stringCalculator.execute("2 2 3 * 4 / "))
            .isInstanceOf(IllegalArgumentException.class);
    }

}