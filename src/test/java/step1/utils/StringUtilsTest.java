package step1.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import step1.domain.Inputs;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @DisplayName("null 또는 공백 입력시 true 반환한다")
    @ParameterizedTest
    @NullAndEmptySource
    void isBlank(String input) {
        assertThat(StringUtils.isBlank(input)).isTrue();
    }

    @DisplayName("디폴트, 커스텀 구분자에 의해 문자열이 split 된다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "//;\n1;2;3"})
    void split(String input) {
        Inputs inputs = Inputs.from(input);
        assertThat(inputs.getInputs().size()).isEqualTo(3);
    }

    @DisplayName("문자가 숫자일 경우 true, 아닐경우 false를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "0,true", "일,false"})
    void isNumber(String input, boolean expected) {
        assertThat(StringUtils.isNumber(input)).isEqualTo(expected);
    }
}