package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {

    @DisplayName("Null 또는 빈 문자열을 입력하면 0을 반환한다")
    @NullAndEmptySource
    @ParameterizedTest
    void splitAndSum_NullAndEmpty_Zero(String formula) {
        int result = StringAddCalculator.splitAndSum(formula);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 문자열로 입력하면 해당 숫자를 반환한다")
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    @ParameterizedTest
    void splitAndSum_SingleNumber_ToInt(String formula) {
        int result = StringAddCalculator.splitAndSum(formula);
        assertThat(result).isEqualTo(Integer.parseInt(formula));
    }

    @DisplayName("숫자 두개를 컴마 구분자로 입력할 경우 두 숫자의 합을 반환한다")
    @CsvSource({"1,2,3", "2,3,5", "3,4,7"})
    @ParameterizedTest
    void splitAndSum_TwoNumberWithComma_Sum(String lOperand, String rOperand, int expected) {
        String formula = lOperand + "," + rOperand;
        int result = StringAddCalculator.splitAndSum(formula);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("숫자 두개를 콜론 구분자로 입력할 경우 두 숫자의 합을 반환한다")
    @CsvSource({"1,2,3", "2,3,5", "3,4,7"})
    @ParameterizedTest
    void splitAndSum_TwoNumberWithColon_Sum(String lOperand, String rOperand, int expected) {
        String formula = lOperand + ":" + rOperand;
        int result = StringAddCalculator.splitAndSum(formula);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("//와 \n 문자 사이에 커스텀 구분자를 사용할 수 있다")
    @CsvSource({"1,2,3", "2,3,5", "3,4,7"})
    @ParameterizedTest
    void splitAndSum_TwoNumberWithCustomDelimiter_Sum(String lOperand, String rOperand, int expected) {
        String formula = "//;\n" + lOperand + ";" + rOperand;
        int result = StringAddCalculator.splitAndSum(formula);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("Formula를 입력하면 입력한 숫자의 합을 반환한다")
    @MethodSource("provideFormulaForSplitAndSum")
    @ParameterizedTest
    void splitAndSum_Formula_Sum(Formula formula, int expected) {
        int result = StringAddCalculator.splitAndSum(formula);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideFormulaForSplitAndSum() {
        return Stream.of(
                Arguments.of(Formula.valueOf("1,2,3,4,5"), 15),
                Arguments.of(Formula.valueOf("1:2:3:4:5"), 15),
                Arguments.of(Formula.valueOf("//;\n1;2;3;4;5"), 15)
        );
    }
}
