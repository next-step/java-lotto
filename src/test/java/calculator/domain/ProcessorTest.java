package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProcessorTest {


    @DisplayName("복잡한 수식을 처리할 수 있다.")
    @Test
    void processArithmeticExpressionTest() {
        // given
        String[] expression = {"2", "+", "3", "*", "4", "/", "2", "-", "3"};

        // when
        int result = ArithmeticProcessor.processExpression(expression);

        // then
        assertThat(result).isEqualTo(7);
    }
}
