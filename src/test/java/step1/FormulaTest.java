package step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FormulaTest {
    
    @Test
    void 수식을_생성한다() {
        //given
        String input = "1:2:3";
        //when
        Formula formula = new Formula(input);
        //then
        assertNotNull(formula);
        assertThat(formula.getFormula()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3",
            "//;\n1;2;3", "//;\n1;2:3", "//;\n1:2:3",
            "//;\n1:2;3", "//;\n1,2,3", "//;\n1,2;3", "//;\n1;2,3"})
    void 수식을_기본_구분자_혹은_커스텀_구분자로_분리한다(String input) {
        //given
        Formula formula = new Formula(input);
        //when
        String[] splitFormula = formula.split();
        //then
        assertThat(splitFormula.length).isEqualTo(3);
    }
}
