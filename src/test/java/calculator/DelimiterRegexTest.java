package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class DelimiterRegexTest {

    @ParameterizedTest
    @CsvSource(value = "//;\\n1;2;3=;", delimiter = '=')
    @DisplayName("커스텀 구분자 가져오기")
    void getCustomDelimiter(String formula, String delimiter) {
        assertThat(DelimiterRegex.getCustomDelimiter(formula)).isEqualTo(delimiter);
    }

    @ParameterizedTest
    @ValueSource(strings = "1;2;3")
    @DisplayName("커스텀 구분자 없을 때 null 확인")
    void getCustomDelimiterNull(String formula) {
        assertThat(DelimiterRegex.getCustomDelimiter(formula)).isEqualTo(null);
    }

    @ParameterizedTest
    @CsvSource(value = "//;\\n1;2;3=1;2;3", delimiter = '=')
    @DisplayName("커스텀 구분자 부분을 제외하고 가져오기")
    void getInput(String formula, String input) {
        assertThat(DelimiterRegex.getInput(formula)).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = "1;2;3")
    @DisplayName("getInput 예외처리")
    void getInputException(String formula) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> DelimiterRegex.getInput(formula));
    }


}
