import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @DisplayName("null 또는 empty 일때 0")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyReturnZero(String formula) {
        assertThat(StringAddCalculator.splitAndSum(formula)).isEqualTo(0);
    }
}
