import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @DisplayName("null 또는 empty 일때 0")
    @ParameterizedTest
    @NullAndEmptySource
    void splitAndSumNullOrEmptyReturnZero(String formula) {
        assertThat(StringAddCalculator.splitAndSum(formula)).isEqualTo(0);
    }

    @DisplayName("숫자 하나 입력시 해당 숫자")
    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "3,3"})
    public void splitAndSumOnlyOneNumber(String formula, int expected) throws Exception {
        int result = StringAddCalculator.splitAndSum(formula);
        assertThat(result).isEqualTo(expected);
    }
}
