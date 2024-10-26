package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stringCalculator.domain.MathExpression;
import stringCalculator.domain.MathExpressionFactory;
import stringCalculator.domain.StringCalculator;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @DisplayName("입력받은 문자열의 문자와 사칙연산을 분리하는 테스트")
    @Test
    public void seperateStringAndOperation() {

        MathExpression expression = MathExpressionFactory.seperateAndCreateMathExpression("1 + 2 * 3");
        assertThat(expression.numbersContains(Arrays.asList(1, 2, 3))).isTrue();
        assertThat(expression.operationsContains(Arrays.asList("+", "*"))).isTrue();
    }

    @DisplayName("입력받은 문자열의 예외사항을 확인하는 테스트")
    @Test
    public void stringInputExceptionCheck() {

        assertThatThrownBy(() ->
                MathExpressionFactory.seperateAndCreateMathExpression("null"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() ->
                MathExpressionFactory.seperateAndCreateMathExpression("1 $ 2 & 3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 문자열의 덧셈 테스트")
    @Test
    public void addTest() {
        assertThat(StringCalculator.add(5, 1)).isEqualTo(6);
    }

    @DisplayName("입력받은 문자열의 뺄셈 테스트")
    @Test
    public void subtractTest() {
        assertThat(StringCalculator.subtract(5, 1)).isEqualTo(4);
    }

    @DisplayName("입력받은 문자열의 곱셈 테스트")
    @Test
    public void multiplyTest() {
        assertThat(StringCalculator.multiply(5, 1)).isEqualTo(10);
    }

    @DisplayName("입력받은 문자열의 나눗셈 테스트")
    @Test
    public void divideTest() {
        assertThat(StringCalculator.divide(6, 2)).isEqualTo(3);
    }

    @DisplayName("입력받은 문자열의 사칙연산 계산 테스트")
    @Test
    public void calculateTest() {
        MathExpression expression = MathExpressionFactory
                .seperateAndCreateMathExpression("1 + 2 * 3 - 2");
        assertThat(StringCalculator.calculateWithMathExpression(expression)).isEqualTo(7);
    }
}


