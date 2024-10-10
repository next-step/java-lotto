package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
    @Test
    void operate_숫자_2개의_덧셈_결과를_반환한다() {
        assertThat(Operator.operate(1, "+", 2)).isEqualTo(3);
    }

    @Test
    void operate_숫자_2개의_뺄셈_결과를_반환한다() {
        assertThat(Operator.operate(6, "-", 2)).isEqualTo(4);
    }

    @Test
    void operate_숫자_2개의_곱셈_결과를_반환한다() {
        assertThat(Operator.operate(8, "*", 2)).isEqualTo(16);
    }

    @Test
    void operate_숫자_2개의_나눗셈_결과를_반환한다() {
        assertThat(Operator.operate(6, "/", 2)).isEqualTo(3);
    }
}
