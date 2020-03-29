import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @DisplayName("null 또는 Empty 받으면 0을 반환")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyFormulaReturnZero(String formula) {
        int result = StringaAddCalculator.splitAndSum(formula);
        assertThat(result).isEqualTo(0);
    }
}
