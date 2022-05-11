package stringCalculator.domains;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperandTest {
    @DisplayName("숫자가 아닌 문자열일 경우 IllegalArgumentException 발생")
    @Test
    void validate() {
        assertThatThrownBy(() -> {
            new Operand("a");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
