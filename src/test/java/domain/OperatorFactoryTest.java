package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorFactoryTest {
    @Test
    public void 덧셈_객체_생성() {
        assertThat(OperatorFactory.getOperator("+")).isInstanceOf(Plus.class);
    }

    @Test
    public void 뺄셈_객체_생성() {
        assertThat(OperatorFactory.getOperator("-")).isInstanceOf(Substraction.class);
    }

    @Test
    public void 곰셉_객체_생성() {
        assertThat(OperatorFactory.getOperator("*")).isInstanceOf(Multiplication.class);
    }

    @Test
    public void 나눗셈_객체_생성() {
        assertThat(OperatorFactory.getOperator("/")).isInstanceOf(Division.class);
    }
}
