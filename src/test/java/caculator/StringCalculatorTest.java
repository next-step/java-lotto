package caculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {
    @Test
    @DisplayName("덧셈을 수행할 수 있다.")
    void add() {
        String input = "1 + 1";
        assertThat(StringCalculator.calculate(input)).isEqualTo(2);
    }

    @Test
    @DisplayName("여러번의 덧셈을 수행할 수 있다.")
    void addMultiple() {
        String input = "1 + 1 + 2";
        assertThat(StringCalculator.calculate(input)).isEqualTo(4);
    }

    @Test
    @DisplayName("뺄셈을 수행할 수 있다.")
    void subtract() {
        String input = "2 - 1";
        assertThat(StringCalculator.calculate(input)).isEqualTo(1);
    }

    @Test
    @DisplayName("곱셈을 수행할 수 있다.")
    void multiply() {
        String input = "2 * 1";
        assertThat(StringCalculator.calculate(input)).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈을 수행할 수 있다.")
    void divide() {
        String input = "2 / 1";
        assertThat(StringCalculator.calculate(input)).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈 결과가 소수점인 경우 내림한다.")
    void divideAndFloor() {
        String input = "10 / 3";
        assertThat(StringCalculator.calculate(input)).isEqualTo(3);
    }

    @Test
    @DisplayName("4가지 사칙연산을 한꺼번에 수행할 수 있다.")
    void calculateAll() {
        String input = "1 + 3 - 2 * 5 / 2";
        assertThat(StringCalculator.calculate(input)).isEqualTo(5);
    }

    @Test
    @DisplayName("null이나 빈 문자열이 들어오는 경우 에러를 던진다.")
    void nullOrEmpty() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.calculate(null);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.calculate("");
        });
    }

    @Test
    @DisplayName("연산자가 사칙연산 기호가 아니면 에러를 던진다.")
    void InvalidOperator() {
        String input = "1 # 3";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.calculate(input);
        });
    }

    @Test
    @DisplayName("피연산자가 정수가 아니면 에러를 던진다.")
    void InvalidOperand() {
        String input = "a + 1";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.calculate(input);
        });
    }
}
