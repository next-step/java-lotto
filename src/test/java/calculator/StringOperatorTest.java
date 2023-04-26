package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringOperatorTest {

    @Test
    void 덧셈연산자() {
        StringOperator stringOperator = StringOperator.of("+");

        assertThat(stringOperator).isEqualTo(StringOperator.ADD);
    }

    @Test
    void 뺄셈연산자() {
        StringOperator stringOperator = StringOperator.of("-");

        assertThat(stringOperator).isEqualTo(StringOperator.SUB);
    }

    @Test
    void 나눗셈연산자() {
        StringOperator stringOperator = StringOperator.of("/");

        assertThat(stringOperator).isEqualTo(StringOperator.DIV);
    }

    @Test
    void 곱셈연산자() {
        StringOperator stringOperator = StringOperator.of("*");

        assertThat(stringOperator).isEqualTo(StringOperator.MUL);
    }
}
