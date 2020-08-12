package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SplitExpressionTest {
    @Test
    void sum() {
        assertThat(new SplitExpression("1:2,3").sum()).isEqualTo(6);
        assertThat(new SplitExpression("//;\n1;2;3").sum()).isEqualTo(6);
    }

    @Test
    void sum_negative() {
        SplitExpression expression = new SplitExpression("-1,-2,-3");

        assertThatThrownBy(expression::sum).isInstanceOf(RuntimeException.class);
    }
}
