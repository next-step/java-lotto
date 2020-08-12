package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SplitExpressionTest {
    @ParameterizedTest
    @ValueSource(strings = {"1:2,3", "//;\n1;2;3"})
    void sum(String expression) {
        assertThat(new SplitExpression(expression).sum()).isEqualTo(6);
    }

    @Test
    void sum_negative() {
        SplitExpression expression = new SplitExpression("-1,-2,-3");

        assertThatThrownBy(expression::sum).isInstanceOf(RuntimeException.class);
    }
}
