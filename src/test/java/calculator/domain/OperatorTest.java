package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class OperatorTest {

    @Test
    void fromName() {
        assertThat(Operator.fromName("+")).isEqualTo(Operator.PLUS);
        assertThat(Operator.fromName("-")).isEqualTo(Operator.MINUS);
        assertThat(Operator.fromName("*")).isEqualTo(Operator.MULTIPLICATION);
        assertThat(Operator.fromName("/")).isEqualTo(Operator.DIVISION);
    }
}