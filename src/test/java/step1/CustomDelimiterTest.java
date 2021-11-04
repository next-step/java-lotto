package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomDelimiterTest {

    @DisplayName("isExist() 커스텀 구분자가 있으면 true를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1:3", "//;\n1:2"})
    void isExistTrueTest(String input) {
        CustomDelimiter customDelimiter = new CustomDelimiter(input);
        assertThat(customDelimiter.isExist()).isTrue();
    }

    @DisplayName("isExist() 커스텀 구분자가 없으면 false를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1:3", "1:2"})
    void isExistFalseTest(String input) {
        CustomDelimiter customDelimiter = new CustomDelimiter(input);
        assertThat(customDelimiter.isExist()).isFalse();
    }


}
