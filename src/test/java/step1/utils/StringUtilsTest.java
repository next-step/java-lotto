package step1.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step1.constants.Constants;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @DisplayName("null이나 공백일경우 true, 아닐경우 false를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {",true", "'',true", "name,false"})
    void isBlank(String input, boolean expected) {
        assertThat(StringUtils.isBlank(input)).isEqualTo(expected);
    }

    @DisplayName("디폴트, 커스텀 구분자에 의해 문자열이 split 된다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "//;\n1;2;3"})
    void split(String input) {
        List<String> inputs = getInputs(input);
        assertThat(inputs.size()).isEqualTo(3);
    }

    private List<String> getInputs(String input) {
        Matcher matcher = Pattern.compile(Constants.CUSTOM_SEPARATOR_PATTERN).matcher(input);
        if (matcher.find()) {
            return Arrays.asList(StringUtils.split(matcher.group(2), matcher.group(1)));
        }
        return Arrays.asList(StringUtils.split(input, Constants.SEPARATOR_PATTERN));
    }

    @DisplayName("문자가 숫자일 경우 true, 아닐경우 false를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "0,true", "일,false"})
    void isNumber(String input, boolean expected) {
        assertThat(StringUtils.isNumber(input)).isEqualTo(expected);
    }
}