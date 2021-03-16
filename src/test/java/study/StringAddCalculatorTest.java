package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * 기능 요구 사항
 * - 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열의 경우, 이를 분리하고 리스트로 반환한다.
 * - (//)와 (\n) 사이 문자를 커스텀 구분자로 하여, 이를 분리하고 리스트로 반환한다.
 *
 * - 문자열 계산기의 구분자로 분리된 숫자들을 받아서, 각 숫자들의 합을 반환한다.
 * - 문자열 계산기에 숫자 이외의 값 또는 음수를 받을 경우, RuntimeException을 throw한다.
 * - 빈 문자열이나 null을 받을 경우, 숫자 0 으로 취급한다.
 */

public class StringAddCalculatorTest {

    @Test
    @DisplayName("콤마(,)로 구분된 문자열 분리하기")
    public void splitExpressionWithComma() {
        Expression result = new InputExpression("1,2,3").split();

        assertThat(result).isEqualTo(new Expression("1", "2", "3"));
    }

    @Test
    @DisplayName("콜론(:)으로 구분된 문자열 분리하기")
    public void splitExpressionWithColon() {
        Expression result = new InputExpression("1:2:3").split();

        assertThat(result).isEqualTo(new Expression("1", "2", "3"));
    }

    @Test
    @DisplayName("콤마(,)와 콜론(:)으로 구분된 문자열 분리하기")
    public void splitExpressionWithMixed() {
        Expression result = new InputExpression("1,2:3").split();

        assertThat(result).isEqualTo(new Expression("1", "2", "3"));
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자로 구분된 문자열 분리하기")
    @ValueSource(strings = {"//;\\n1;2;3", "//|\\n1|2|3", "//-\\n1-2-3"})
    public void splitExpressionWithCustomDelimiter(String inputString) {
        Expression result = new InputExpression(inputString).split();

        assertThat(result).isEqualTo(new Expression("1", "2", "3"));
    }

    @Test
    @DisplayName("숫자들을 받으면, 각 숫자들의 합을 반환하기")
    public void sum() {
        StringAddCalculator calculator =
                new StringAddCalculator(new Expression("1", "2", "3"));

        int result = calculator.sum();

        assertThat(result).isEqualTo(6);
    }

}
