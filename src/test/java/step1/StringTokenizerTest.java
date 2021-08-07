package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class StringTokenizerTest {

    @ParameterizedTest
    @DisplayName("input이 한 개인 경우 하나를 리턴 하는지 테스트")
    @ValueSource(strings = {"0","1","2"})
    void oneElementTest(String input) {
        StringTokenizer tokenizer = new StringTokenizer();
        String[] actual = tokenizer.tokenize(input);

        assertThat(actual).hasSize(1)
                .contains(input);
    }

    @ParameterizedTest
    @DisplayName("빈 문자열, null인 경우 0을 리턴 하는지 테스트")
    @NullAndEmptySource
    void nullOrEmptyTest(String input) {
        StringTokenizer tokenizer = new StringTokenizer();
        String[] actual = tokenizer.tokenize(input);

        assertThat(actual).hasSize(1)
                .contains("0");
    }

    @ParameterizedTest
    @DisplayName("',' 구분자를 가지는 문자열을 tokenize 할 수 있는지 테스트")
    @ValueSource(strings = "1,2,3")
    void defaultDelimiterTest(String input) {
        StringTokenizer tokenizer = new StringTokenizer();
        assertDoesNotThrow(() -> tokenizer.tokenize(input));
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자를 사용한 문자열을 tokenize 할 수 있는지 테스트")
    @CsvSource(value = {"'//;\n1;2;3','123'", "'//-\n1-2-3','123'", "'//:\n1:2:3','123'"})
    void customDelimiterTest(String input, String answer) {
        StringTokenizer tokenizer = new StringTokenizer();
        String[] actual = tokenizer.tokenize(input);
        String[] expected = answer.split("");
        assertThat(actual).isEqualTo(expected);
    }
}
