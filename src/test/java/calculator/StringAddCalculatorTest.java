package calculator;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
    @DisplayName("null 또는 빈문자")
    @Test
    void splitAndSum_null_or_emptyStr() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum(" ");
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자하나")
    @Test
    void splitAndSum_singleNum() {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("쉼표 구분자")
    @ParameterizedTest
    @CsvSource(value = {"1,2=3","1,2,3=6", "1,2,3,4=10"},delimiter = '=')
    public void splitAndSum_commaSeparator(String text, int answer) {
        int calculatedResult = StringAddCalculator.splitAndSum(text);
        assertThat(calculatedResult).isEqualTo(answer);
    }

    @DisplayName("쉼표 또는 콜론 구분자")
    @ParameterizedTest
    @CsvSource(value = {"1:2=3","1,2:3=6", "1,2:3:4=10"},delimiter = '=')
    public void splitAndSum_commaOrColonSeparator(String text, int answer) {
        int calculatedResult = StringAddCalculator.splitAndSum(text);
        assertThat(calculatedResult).isEqualTo(answer);
    }

    @DisplayName("기본구분자(쉼표,콜론)이 아닌 문자가 들어온 경우 0리턴")
    @ParameterizedTest
    @CsvSource(value = {"1-2=0","1a2b3=0", "a13413aaaa=0"},delimiter = '=')
    public void splitAndSum_unexpectedSeparator(String text, int answer) {
        int calculatedResult = StringAddCalculator.splitAndSum(text);
        assertThat(calculatedResult).isEqualTo(answer);
    }

    private static class StringAddCalculator {
        private static final int DEFAULT_VALUE = 0;
        private static final String DEFAULT_SEPARATOR = "[,:]";
        private static final String DEFAULT_SEPARATOR_PATTERN = format("\\d+(?:%s\\d+){0,}",DEFAULT_SEPARATOR);

        public static int splitAndSum(String text) {
            if (null == text || "".equals(text.trim())) {
                return DEFAULT_VALUE;
            }
            return defaultSplitAndSum(text);
        }
        private static int defaultSplitAndSum(String text){
            if (text.matches(DEFAULT_SEPARATOR_PATTERN)) {
                return Arrays.stream(text.split(DEFAULT_SEPARATOR))
                         .mapToInt(Integer::parseInt)
                         .sum()
                ;
            }
            return DEFAULT_VALUE;
        }
    }
}
