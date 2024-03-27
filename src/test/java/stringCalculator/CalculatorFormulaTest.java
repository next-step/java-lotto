package stringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowableOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import stringCalculator.domain.CalculationFormula;
import stringCalculator.error.exception.NullBlankException;
import stringCalculator.error.exception.WhiteSpaceMissingException;

public class CalculatorFormulaTest {

    @Test
    @DisplayName("사칙연산 사이 빈 공백 문자열이 없을 경우 예외가 발생해야한다")
    public void CalculationFormula_Should_Occur_Exception_When_Input_Empty_String()
        throws Exception {
        //given
        String input = "2+3*4/2" ;

        //when
        WhiteSpaceMissingException actual = catchThrowableOfType(
            () -> new CalculationFormula(input), WhiteSpaceMissingException.class);

        //then
        assertThat(actual).hasMessage("입력값은 한 칸씩 띄어져 있어야 합니다, 입력값 : 2+3*4/2");
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
    @DisplayName("빈 공백 문자일 경우 NullBlankException throw 예외를 발생한다.")
    public void CalculatorFormula_Should_Occur_Exception_When_Input_Is_Null_Or_Empty(String input)
        throws Exception {
        //given
        //when
        NullBlankException actual = catchThrowableOfType(
            () -> new CalculationFormula(input), NullBlankException.class);

        //then
        assertThat(actual).hasMessageContaining("입력값은 NULL 또는 빈 문자열일수 없습니다");
    }
}

