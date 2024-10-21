import StringCalculator.MathExpression;
import StringCalculator.MathExpressionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {


    @DisplayName("입력받은 문자열의 문자와 사칙연산을 분리하는 테스트")
    @Test
    void seperateStringAndOperation() {

        MathExpression expression = MathExpressionFactory.seperateAndCreateMathExpression("1 + 2 * 3");
        assertThat(expression.numbersContains(Arrays.asList(1, 2, 3))).isTrue();
        assertThat(expression.operationsContains(Arrays.asList("+", "*"))).isTrue();
    }
}


