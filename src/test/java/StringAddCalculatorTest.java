import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("콤마 또는 콜론 구분자를 기준으로 분리한 각 숫자의 합을 리턴한다")
    public void splitAndSumReturnsSumOfNumbersInString() {
        int result = StringAddCalculator.splitAndSum("1,2:3");

        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 빈 문자열이 입력될 경우 0을 리턴한다")
    public void splitAndSumWithNullOrEmptyReturnsZero(String input) {
        int result = StringAddCalculator.splitAndSum(input);

        assertThat(result).isEqualTo(0);
    }
}
