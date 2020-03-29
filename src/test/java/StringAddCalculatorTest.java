import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @DisplayName("null 또는 Empty 받으면 0을 반환")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyFormulaReturnZero(String formula) {
        int result = StringAddCalculator.splitAndSum(formula);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 입력하면 해당 숫자 반환")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void onlyOneNumberInput(String number) {
        int result = StringAddCalculator.splitAndSum(number);
        assertThat(result).isEqualTo(Integer.parseInt(number));
    }

    @DisplayName("구분자로 컴마 사용 가능")
    @ParameterizedTest
    @CsvSource(value = {"1,2?3"}, delimiter = '?')
    void splitComma(String formula, int expected) {
        int result = StringAddCalculator.splitAndSum(formula);
        assertThat(result).isEqualTo(expected);
    }
}
