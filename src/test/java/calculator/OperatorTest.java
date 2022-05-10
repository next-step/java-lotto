package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    @Test
    void 더하기() {
        assertThat(Operator.fromString("+").calculate(1, 2)).isEqualTo(3);
    }

    @Test
    void 빼기() {
        assertThat(Operator.fromString("-").calculate(1, 2)).isEqualTo(-1);
    }

    @Test
    void 곱하기() {
        assertThat(Operator.fromString("*").calculate(2, 3)).isEqualTo(6);
    }

    @Test
    void 나누기() {
        assertThat(Operator.fromString("/").calculate(6, 2)).isEqualTo(3);
    }

}
