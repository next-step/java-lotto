import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @DisplayName("null 또는 empty 일때 0")
    @ParameterizedTest
    @NullAndEmptySource
    void splitAndSumNullOrEmptyReturnZero(String expression) {
        assertThat(StringAddCalculator.splitAndSum(expression)).isEqualTo(0);
    }

    @DisplayName("숫자 하나 입력시 해당 숫자")
    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "3,3"})
    public void splitAndSumOnlyOneNumber(String expression, int expected) throws Exception {
        int result = StringAddCalculator.splitAndSum(expression);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("구분자로 컴마 사용 가능")
    @Test
    public void splitAndSumSplitComma() {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("구분자로 콤마 또는 콜론 사용 가능")
    @Test
    public void splitAndSumSplitCommaAndColon() {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자 사용 가능")
    @Test
    public void splitAndSumCustomDelimiter() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }
}
