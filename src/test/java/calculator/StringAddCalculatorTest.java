package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @DisplayName("사용자 정의 구분자")
    @Test
    public void splitAndSum_customSeparator() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2")).isEqualTo(3);
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3;4")).isEqualTo(10);
    }

    private static class StringAddCalculator {
        private static final int DEFAULT_VALUE = 0;
        private static final String DEFAULT_SEPARATOR = "[,:]";
        private static final String DEFAULT_SEPARATOR_PATTERN = format("\\d+(?:%s\\d+)*",DEFAULT_SEPARATOR);
        private static final String CUSTOM_SEPARATOR_PATTERN = "//(?<customDelimiter>[^/])\n(?<text>\\d+(\\k<customDelimiter>\\d)*)";
        private static final Pattern customPattern = Pattern.compile(CUSTOM_SEPARATOR_PATTERN);

        public static int splitAndSum(String text) {
            if (null == text || "".equals(text.trim())) {
                return DEFAULT_VALUE;
            }
            int defaultSplitAndSum = defaultSplitAndSum(text);
            if (0 == defaultSplitAndSum){
                return customSplitAndSum(text);
            }
            return defaultSplitAndSum;
        }

        private static int defaultSplitAndSum(String text){
            if (text.matches(DEFAULT_SEPARATOR_PATTERN)) {
                String[] defaultSplit = text.split(DEFAULT_SEPARATOR);
                return numStringsToSum(text.split(DEFAULT_SEPARATOR));
            }
            return DEFAULT_VALUE;
        }

        static int customSplitAndSum(String customText){
            final Matcher matcher = customPattern.matcher(customText);
            if (matcher.matches()) {
                final String customDelimiter = matcher.group("customDelimiter");
                final String text = matcher.group("text");
                return numStringsToSum(text.split(customDelimiter));
            }
            return DEFAULT_VALUE;
        }

        private static int numStringsToSum(String[] splitNumStrings) {
            return Arrays.stream(splitNumStrings)
                         .mapToInt(Integer::parseInt)
                         .sum();
        }
    }
}
