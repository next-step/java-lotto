package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다")
    @Test
    void emptyString() {
        double sum1 = Calculator.sum("");
        assertThat(sum1).isEqualTo(0);

        double sum2 = Calculator.sum(null);
        assertThat(sum2).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다")
    @Test
    void singleNumber() {
        double sum = Calculator.sum("23");
        assertThat(sum).isEqualTo(23);
    }

    @DisplayName("문자열 덧셈 계산기는 ':'를 구분자로 하여 각 문자열을 분리할 수 있다")
    @Test
    void colonDelimiter() {
        double sum1 = Calculator.sum("10:25:33");
        assertThat(sum1).isEqualTo(68);

        double sum2 = Calculator.sum("10:25,33");
        assertThat(sum2).isEqualTo(68);
    }

    @DisplayName("문자열 덧셈 계산기는 ','를 구분자로 하여 각 문자열을 분리한 후 합을 구할 수 있다")
    @Test
    void sumEachTokens() {
        double sum = Calculator.sum("1,2,3,4,5");
        assertThat(sum).isEqualTo(15);
    }

    @DisplayName("문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,a,b,3", "1,2,5,-10,3", "#,#,#,$,!", "-1,-2,-3", "!@,@#,$#", "e,e,e,e,e"})
    void throwRuntimeExceptionsIfNonNumberOrNegativeNumber(String target) {
        assertThatThrownBy(() -> {
            Calculator.sum(target);
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("기본 구분자와 함께 문자열 앞부분의 \"//\"와 \"\\n\" 사이에 위치하는 문자를 커스텀 구분자로 사용할 수 있다")
    @Test
    void splitUsingCustomDelimiter() {
        String expression1 = "//;\n1;2;3";
        assertThat(Calculator.sum(expression1)).isEqualTo(6);

        String expression2 = "//;\n1,2;3;4;5";
        assertThat(Calculator.sum(expression2)).isEqualTo(15);

        String expression3 = "//:\n3:4:5,6,7";
        assertThat(Calculator.sum(expression3)).isEqualTo(25);
    }
}
