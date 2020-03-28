package Calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @DisplayName("빈 문자열 혹은 null 을 집어넣었을 때 0을 반환한다.")
    @NullAndEmptySource
    public void splitAndSum_null_또는_빈문자(final String str) {
        int result = StringAddCalculator.splitAndSum(str);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "10:10"}, delimiter = ':')
    public void splitAndSum_숫자하나(final String str, final int answer) throws Exception {
        int result = StringAddCalculator.splitAndSum(str);
        assertThat(result).isEqualTo(answer);
    }


    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

}
