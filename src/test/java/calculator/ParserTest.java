package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    @DisplayName("입력한 문자열을 Element로 파싱한다")
    void parseTest() {
        Assertions.assertThat(Parser.parseExpression("2 + 3 * 4 / 2")).containsExactly(
                new Element(Operator.START, 2),
                new Element(Operator.PLUS, 3),
                new Element(Operator.MULTIPLY, 4),
                new Element(Operator.DIVIDE, 2)
        );
    }

    @Test
    @DisplayName("입력한 문자열이 null이거나 빈 문자열이면 에러가 발생한다")
    void parseNullOrEmptyFailTest() {
        Assertions.assertThatThrownBy(() -> Parser.parseExpression(null))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> Parser.parseExpression(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("피연산자가 숫자가 아니면 에러가 발생한다")
    void parseOperandNotNumberFailTest() {
        Assertions.assertThatThrownBy(() -> Parser.parseExpression("a + 3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("연산자가 +, -, *, /가 아니면 에러가 발생한다")
    void parseInvalidOperatorFailTest() {
        Assertions.assertThatThrownBy(() -> Parser.parseExpression("2 & 3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
