package step1.calc.operand;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class OperandTest {

    @Test
    public void type_error_문자열이_공백일때_예외를_throw한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Operand("");
        }).withMessage("operand is empty");
    }

    @Test
    public void type_error_문자열이_null일때_예외를_throw한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Operand(null);
        }).withMessage("operand is empty");
    }

    @Test
    public void type_error_문자열이_숫자가_아닐때_예외를_throw한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Operand("a");
        }).withMessage("operand is not numeric");
    }
}
