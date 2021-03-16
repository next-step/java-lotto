package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 *
 * 기능 요구 사항
 * - 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열의 경우, 이를 분리하고 리스트로 반환한다.
 */

public class StringAddCalculatorTest {

    @Test
    public void splitExpressionWithComma() {
        List<String> result = new InputExpression("1,2,3").split();

        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    public void splitExpressionWithColon() {
        List<String> result = new InputExpression("1:2:3").split();

        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    public void splitExpressionWithMixed() {
        List<String> result = new InputExpression("1,2:3").split();

        assertThat(result).containsExactly("1", "2", "3");
    }
}
