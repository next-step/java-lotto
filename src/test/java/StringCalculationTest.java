import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculationTest {

    @DisplayName("빈문자열 기준으로 문자를 Split할 수 있다,")
    @Test
    void splitByGap() {
        assertThat(StringCalculation.splitByGap("1 + 3")).containsExactly("1", "+", "3");
        assertThat(StringCalculation.splitByGap("")).containsExactly("");
    }

    @DisplayName("문자열을 순서대로 사칙연상을 할 수 있다,")
    @ParameterizedTest
    @CsvSource(value = {"1 + 3,4", "1 - 2,-1",}, delimiterString = ",")
    void calculate(String input, int expectedResult) {
        int actualResult = StringCalculation.calculate(input);
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
