package calculator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class OperatorTest {

    @Test
    void testInvalidOperator() {
        assertThatIllegalArgumentException().isThrownBy(() -> Operator.of("%"));
    }
}
