package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"//[\\n1[2[3=6", "//*\\n1*2*8=11", "1,2,3,4=10",
        "1,2,3:4=10"}, delimiter = '=')
    void calculateTest(String str, String sum) {
        assertThat(Calculator.plus(str) == Integer.parseInt(sum)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void blankAndNullCheckTest(String str) {
        assertThat(Calculator.plus(str)).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "120", "4358"})
    void onlyOneStringCheckTest(String str) {
        assertThat(Calculator.plus(str)).isEqualTo(Integer.parseInt(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2", "20,30", "123,345"})
    void onlyCommaSeperatorCheckTest(String str) {
        assertThat(Calculator.plus(str)).isEqualTo(
            Arrays.stream(str.split(",")).map(Integer::parseInt).mapToInt(Integer::intValue).sum());
    }
}
