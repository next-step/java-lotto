package stringcalculator.domain;

import domain.StringCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @DisplayName("입력값이 null일 경우 예외가 발생한다.")
    @Test
    public void calculateString_InputIsNull_ThrowException() {
        String input = null;
        StringCalculator stringCalculator = new StringCalculator();
        Assertions.assertThatThrownBy(() ->
                stringCalculator.calculateString(input));
    }

    @DisplayName("입력값이 null일 경우 예외가 발생한다.")
    @Test
    public void calculateString_InputIsEmpty_ThrowException() {
        String input = "";
        StringCalculator stringCalculator = new StringCalculator();
        Assertions.assertThatThrownBy(() ->
                stringCalculator.calculateString(input));
    }
    @DisplayName("입력 연산의 총 갯수가 짝수면 예외가 발생한다.")
    @Test
    public void calculateString_SeparatedStringLengthIsEven_ThrowException() {
        String input = "3 + 4 *";
        StringCalculator stringCalculator = new StringCalculator();
        Assertions.assertThatThrownBy(() ->
                stringCalculator.calculateString(input));
    }

    @DisplayName("피연산자는 반드시 숫자형태여야 한다.")
    @Test
    public void calculateString_OperandMustBeNumberFormat_ThrowException() {
        String input = "3 + a *";
        StringCalculator stringCalculator = new StringCalculator();
        Assertions.assertThatThrownBy(() -> stringCalculator.calculateString(input))
                .isInstanceOf(NumberFormatException.class);
    }

}
