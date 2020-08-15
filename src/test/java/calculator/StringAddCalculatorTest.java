package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("기본 구분자 사용하는 수식 더하기")
    void splitExpression() {
        // when
        int result = StringAddCalculator.calculate("1,2:3");

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자 사용하는 수식 더하기")
    void splitExpressionByCustomDelimiter() {
        // when
        int result = StringAddCalculator.calculate("//;\n5;10;200");

        // then
        assertThat(result).isEqualTo(215);
    }
}
