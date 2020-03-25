import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    void isNullOrEmptyTest(String input) {
        assertThat(StringAddCalculator.isNullOrEmpty(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"2,4,5:3", "23,4:2", "2,24,20,1,5:5"}, delimiter = ':')
    void splitTest(String input, int expected) {
        assertThat(StringAddCalculator.splitByDefault(input).length).isEqualTo(expected);
    }
}
