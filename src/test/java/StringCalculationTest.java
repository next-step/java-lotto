import domain.operations.StringCalculation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculationTest {

    @DisplayName("공백문자열 기준으로 문자를 Split할 수 있다,")
    @Test
    void splitByGap() {
        assertThat(StringCalculation.splitByGap("1 + 3")).containsExactly("1", "+", "3");
    }

    @DisplayName("빈문자열 또는 Null 값이면 예외를 던진다.")
    @ParameterizedTest
    @NullAndEmptySource
    void splitByGapWithNullOrBlank(String str) {
        assertThatThrownBy(() -> StringCalculation.splitByGap(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열을 순서대로 사칙연상을 할 수 있다,")
    @ParameterizedTest
    @CsvSource(value = {"1 + 3,4", "1 - 2,-1", "1 / 3,0", "5 / 2,2", "1 * 3,3", "5 * 5,25", "2 + 3 * 4 / 2,10"}, delimiterString = ",")
    void calculate(String input, int expectedResult) {
        int actualResult = StringCalculation.getSum(input);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

}
