package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class FormulaTest {

    @Test
    @DisplayName("빈 문자 입력하면 exception")
    void formulaNullValidation() {

        String inputFormula = null;
        assertThatThrownBy(() -> new Formula(inputFormula))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 exception")
    void operatorValidation() {

        String inputFormula = "1 - 2 @ 3";
        assertThatThrownBy(() -> new Formula(inputFormula))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
