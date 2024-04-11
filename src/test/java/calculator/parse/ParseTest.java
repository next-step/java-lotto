package calculator.parse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParseTest {

    @Test
    @DisplayName("계산식 문자열을 각각 요소로 반환한다.")
    public void parseTest(){

        ExpressionParser parser = new ExpressionParser();
        String[] expressionElements = parser.parse("2 * 3 + 2");
        assertThat(expressionElements).containsExactly(new String[]{"2", "*", "3", "+", "2"});
    }

    @Test
    @DisplayName("계산식의 숫자과 연산자를 반환한다.")
    public void nextTest(){
        ExpressionParser parser = new ExpressionParser();
        parser.parse("2 * 3 + 2");
        String[] nextExpression = parser.next();

        assertThat(nextExpression).containsExactly(new String[]{"2", "*", "3"});
    }
}
