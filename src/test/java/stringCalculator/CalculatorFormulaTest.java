package stringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowableOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import stringCalculator.domain.CalculationFormula;
import stringCalculator.error.ErrorMessage;

public class CalculatorFormulaTest {

    @Test
    @DisplayName("사칙연산 사이 빈 공백 문자열이 없을 경우 예외가 발생해야한다")
    public void CalculationFormula_Should_Occur_Exception_When_Input_Empty_String()
        throws Exception {
        //given
        String input = "2+3*4/2" ;

        //when
        IllegalArgumentException actual = catchThrowableOfType(
            () -> new CalculationFormula(input), IllegalArgumentException.class);

        //then
        assertThat(actual).hasMessageContaining(
            ErrorMessage.INPUT_VALUE_VALID_BLANK_SPACE.getErrorMessage());
    }

    @Test
    @DisplayName("입력값은 한 칸의 공백을 유지하며 숫자와 연산자로 이뤄져있어야한다")
    public void CalculationFormula_Contain_One_Space_And_Consist_Numbers_And_Operators()
        throws Exception {
        //given
        String input = "2 * 3 + 4 + 5" ;
        int expected = 7;

        //when
        CalculationFormula calculationFormula = new CalculationFormula(input);

        //then
        String[] strings = calculationFormula.parseCalculationFormula();
        assertThat(strings).hasSize(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  "})
    @DisplayName("빈 공백 문자일 경우 IllegalArgumentException throw 예외를 발생한다.")
    public void CalculatorFormula_Should_Occur_Exception_When_Input_Is_Null_Or_Empty(String input)
        throws Exception {
        //given
        //when
        IllegalArgumentException actual = catchThrowableOfType(
            () -> new CalculationFormula(input), IllegalArgumentException.class);

        //then
        assertThat(actual).hasMessageContaining(
            ErrorMessage.INPUT_VALUE_NOT_NULL_AND_BLANK.getErrorMessage());
    }
}

