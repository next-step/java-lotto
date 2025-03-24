package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTest {
    @Test
    void 예외() {
        assertThatThrownBy(() -> {
            Operator.fromValue("?");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
