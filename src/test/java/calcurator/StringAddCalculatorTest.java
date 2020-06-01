package calcurator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {
    @ParameterizedTest
    @NullSource
    @EmptySource
    @DisplayName("null 또는 빈문자")
    void splitAndSum(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(Const.INITIAL_NUMBER_ZERO);
    }
}