package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * 기능 요구 사항
 * - 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열의 경우, 이를 분리하고 리스트로 반환한다.
 * - (//)와 (\n) 사이 문자를 커스텀 구분자로 하여, 이를 분리하고 리스트로 반환한다.
 */

public class StringAddCalculatorTest {

    @Test
    public void splitExpressionWithComma() {
        Expression result = new InputExpression("1,2,3").split();

        assertThat(result).isEqualTo(new Expression("1", "2", "3"));
    }

    @Test
    public void splitExpressionWithColon() {
        Expression result = new InputExpression("1:2:3").split();

        assertThat(result).isEqualTo(new Expression("1", "2", "3"));
    }

    @Test
    public void splitExpressionWithMixed() {
        Expression result = new InputExpression("1,2:3").split();

        assertThat(result).isEqualTo(new Expression("1", "2", "3"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n1;2;3", "//|\\n1|2|3", "//-\\n1-2-3"})
    public void splitExpressionWithCustomDelimiter(String inputString) {
        Expression result = new InputExpression(inputString).split();

        assertThat(result).isEqualTo(new Expression("1", "2", "3"));
    }

}
