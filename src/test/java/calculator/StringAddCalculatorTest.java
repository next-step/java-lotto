package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열 또는 null 입력 시 0 반환")
    void nullAndEmptyTest(String input) {
        int result = StringAddCalculator.splitAndSum(input);

        assertThat(result).isEqualTo(0);
    }

}
