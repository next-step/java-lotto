package stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    private StringAddCalculator stringAddCalculator = new StringAddCalculator();

    @ParameterizedTest
    @NullAndEmptySource
    public void splitAndSum_null_또는_빈문자일때_0반환(String nullOrEmpty) {
        int result = stringAddCalculator.splitAndSum(nullOrEmpty);

        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1=1", "1,2=3",  "1,2:3=6"}, delimiter = '=')
    public void splitAndSum_일반구분자_총합계산_또는_숫자하나반환_정상일때(String input, int expected) {
        int result = stringAddCalculator.splitAndSum(input);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//@\n2@1@3", "//:\n1:2:3"})
    public void splitAndSum_custom_구분자_사용시_총합계산(String input) {
        int result = stringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_음수_전달시_예외발생() {
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자값에는 음수가 올 수 없습니다.");
    }
}
