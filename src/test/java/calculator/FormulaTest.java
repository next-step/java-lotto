package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FormulaTest {

    @Test
    void 입력값_NULL_예외() {
        assertThatThrownBy(() -> {
            Formula formula = new Formula(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값_공백_예외() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Formula formula = new Formula("   ");
        });
    }

}
