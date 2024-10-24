package StringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

//    @DisplayName("입력받은 문자열의 문자와 사칙연산을 분리하는 테스트")
//    @Test
//    void seperateStringAndOperation() {
//
//        MathExpression expression = MathExpressionFactory.seperateAndCreateMathExpression("1 + 2 * 3");
//        assertThat(expression.numbersContains(Arrays.asList(1, 2, 3))).isTrue();
//        assertThat(expression.operationsContains(Arrays.asList("+", "*"))).isTrue();
//    }

    @DisplayName("입력받은 문자열의 예외사항을 확인하는 테스트")
    @Test
    void stringInputExceptionCheck() {

        assertThatThrownBy(()->
                MathExpressionFactory.seperateAndCreateMathExpression(null))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->
                MathExpressionFactory.seperateAndCreateMathExpression("1 $ 2 & 3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}


