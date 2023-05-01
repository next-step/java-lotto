package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {

    @DisplayName("두 개의 수를 더할 수 있다.")
    @Test
    public void add_TwoOperand_ResultCorrect() {
        String input = "6 + 3";
        int result = 6 + 3;

        StringCalculator stringCalculator = new StringCalculator();
        int answer = stringCalculator.calculateString(input);

        Assertions.assertThat(result).isEqualTo(answer);
    }

    @DisplayName("두 개의 수를 뺄 수 있다.")
    @Test
    public void subtract_TwoOperand_ResultCorrect() {
        String input = "6 - 3";
        int result = 6 - 3;

        StringCalculator stringCalculator = new StringCalculator();
        int answer = stringCalculator.calculateString(input);

        Assertions.assertThat(result).isEqualTo(answer);
    }

    @DisplayName("두 개의 수를 곱할 수 있다.")
    @Test
    public void multiply_TwoOperand_ResultCorrect() {
        String input = "6 * 3";
        int result = 6 * 3;

        StringCalculator stringCalculator = new StringCalculator();
        int answer = stringCalculator.calculateString(input);

        Assertions.assertThat(result).isEqualTo(answer);
    }

    @DisplayName("두 개의 수를 나눌 수 있다.")
    @Test
    public void divine_TwoOperand_ResultCorrect() {
        String input = "6 / 3";
        int result = 6 / 3;

        StringCalculator stringCalculator = new StringCalculator();
        int answer = stringCalculator.calculateString(input);

        Assertions.assertThat(result).isEqualTo(answer);
    }

    @DisplayName("여러 개의 연산을 수행할 수 있다.")
    @Test
    public void calculateString_SeveralOperand_ResultCorrect() {
        String input = "2 + 3 * 4 / 2";
        int result = 10;

        StringCalculator stringCalculator = new StringCalculator();
        int answer = stringCalculator.calculateString(input);

        Assertions.assertThat(result).isEqualTo(answer);
    }

    @DisplayName("사칙 연산이 아닌 문자가 들어간 경우 에러를 발생한다.")
    @Test
    public void calculateString_ElseStringOperator_ThrowException() {
        String input = "2 + 3 ( 4 / 2";

        StringCalculator stringCalculator = new StringCalculator();
        Assertions.assertThatThrownBy(() -> stringCalculator.calculateString(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0으로 나누게 되는 경우 에러를 발생한다.")
    @Test
    public void calculateString_DivineByZero_ThrowException() {
        String input = "2 / 0";

        StringCalculator stringCalculator = new StringCalculator();
        Assertions.assertThatThrownBy(() -> stringCalculator.calculateString(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값이 null이면 에러를 발생한다.")
    public void calculateString_InputIsNull_ThrowException() {
        String input = null;

        StringCalculator stringCalculator = new StringCalculator();
        Assertions.assertThatThrownBy(() -> stringCalculator.calculateString(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값이 공백이면 에러를 발생한다.")
    public void calculateString_InputIsEmpty_ThrowException() {
        String input = "";

        StringCalculator stringCalculator = new StringCalculator();
        Assertions.assertThatThrownBy(() -> stringCalculator.calculateString(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
