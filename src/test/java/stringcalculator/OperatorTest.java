package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    @Test
    void 덧셈() {
        int actual = Operator.add(1, 3);
        assertThat(actual).isEqualTo(4);
    }
}
