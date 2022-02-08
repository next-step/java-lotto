package calculator;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

public class OperandTest {
    
    @Test
    void 숫자가_아닐시_예외() {
        assertThatExceptionOfType(NumberFormatException.class)
          .isThrownBy(() -> new Operand("*"));
    }
}
