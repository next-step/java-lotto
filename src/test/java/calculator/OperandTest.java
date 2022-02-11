package calculator;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

public class OperandTest {
    
    @Test
    void 숫자가_아닐시_예외() {
        assertThatExceptionOfType(NumberFormatException.class)
          .isThrownBy(() -> new Operand("*"));
    }
    
    @Test
    void 음수일_경우_예외() {
        assertThatExceptionOfType(RuntimeException.class)
          .isThrownBy(() -> new Operand("-3"));
    }
}
