package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class DelimiterTest {

    @DisplayName("isExist() 구분자의 값이 있으면 true를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1:3", "//;\n1:2"})
    void isExistTrueTest(String input) {
        String pattern_string = "//(.)\n(.*)";
        Pattern pattern = Pattern.compile(pattern_string);
        Delimiter delimiter = Delimiter.customByPattern(input,pattern);
        assertThat(delimiter.isExist()).isTrue();
    }

    @DisplayName("isExist() 커스텀 구분자가 없으면 false를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1:3", "1:2"})
    void isExistFalseTest(String input) {
        String pattern_string = "//(.)\n(.*)";
        Pattern pattern = Pattern.compile(pattern_string);
        Delimiter delimiter = Delimiter.customByPattern(input, pattern);
        assertThat(delimiter.isExist()).isFalse();
    }

    @DisplayName("withDefaultDelimiter() 기본 구분자를 반환한다.")
    @Test
    void withDefaultDelimiterTest() {
        Delimiter delimiter = Delimiter.withDefaultDelimiter();
        assertThat(delimiter).isEqualTo(Delimiter.custom(":|,"));
    }

    @DisplayName("addDelimiter()는 delimiter를 합쳐서 반환한다.")
    @Test
    void addDelimiterTest() {
        Delimiter delimiter = Delimiter.custom(":|,");
        Delimiter customDelimiter = Delimiter.custom(";");

        Delimiter result = delimiter.addDelimiter(customDelimiter);

        assertThat(result).isEqualTo(Delimiter.custom(":|,|;"));
    }

//    @DisplayName("addDelimiter() 커스텀 구분자가 있으면 입력값과 함께 커스텀 구분자를 반환한다.")
//    @ParameterizedTest
//    @ValueSource(strings = {"//;\n1:", "//;\n1:2"})
//    void getDelimiterTest(String input) {
//        Delimiter delimiter = Delimiter.create(input);
//        assertThat(delimiter.delimiter()).isTrue();
//    }


}
