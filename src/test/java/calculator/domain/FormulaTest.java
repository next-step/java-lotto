package calculator.domain;

import calculator.domain.Formula;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class FormulaTest {

    @Test
    public void formulaTest() {
        Formula formula = new Formula("2 + 3 * 4 / 2");
        assertThat(formula.getFirstSingleFormula().doOperate()).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    public void exceptionTest1(String string) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Formula(string);
        });
    }

    @Test
    public void exceptionTest2() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Formula(null);
        });
    }
}