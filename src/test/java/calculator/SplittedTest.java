package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SplittedTest {
    
    @Test
    @DisplayName("구분자를 통한 문자열 분리 테스트")
    public void split() throws Exception {
        Expression expression = new Expression("//;\n1;2,3:4");
        Splitted splittedExpression = new Splitted(expression);
        assertThat(splittedExpression.expression()).containsExactly("1","2","3","4");
    }
}