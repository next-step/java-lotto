package Lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
    @Test
    void 생성() {
        assertThat(new Operator("+")).isEqualTo(new Operator("+"));
    }

    @Test
    void 연산() {
        assertThat(new Operator("+").operate(1, 2)).isEqualTo(1 + 2);
    }
}
