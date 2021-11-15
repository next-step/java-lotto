package step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3",
            "//a\n1a2a3", "//+\n1+2:3", "//;\n1:2:3"})
    void 수식의_합을_계산한다(String input) {
        //given
        Formula formula = new Formula(input);
        //when
        int result = formula.calculate();
        //then
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 수식이_빈값이면_결과는_0_이다(String input) {
        //given
        Formula formula = new Formula(input);
        //when
        int result = formula.calculate();
        //then
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,a", "1:-2:3", "i1,2:3",
            "//;\n1;-2;3", "//;\n1;e:3", "//;\n-x:2:3"})
    void 수식에_음수_혹은_문자가_포함되어_있으면_RuntimeException이_발생한다(String input) {
        //given
        Formula formula = new Formula(input);
        //when & then
        assertThatThrownBy(formula::calculate)
                .isInstanceOf(RuntimeException.class);
    }
}
