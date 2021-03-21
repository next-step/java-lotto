package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SumTest {
    
    @Test
    @DisplayName("수식의 숫자를 더하는 테스트")
    public void sum() throws Exception {
        Expression expression = new Expression("1,2,3");
        Splitted splittedExpression = new Splitted(expression);
        assertThat(new Sum(splittedExpression).sum()).isEqualTo(6);
    }
}