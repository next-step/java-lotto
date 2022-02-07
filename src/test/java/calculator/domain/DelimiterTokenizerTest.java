package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DelimiterTokenizerTest {

    @Test
    void 기본_구분자_반환() {
        final String text = "1,2:3";
        final DelimiterTokenizer delimiterTokenizer = new DelimiterTokenizer(text);
        assertThat(delimiterTokenizer.getDelimiters()).isEqualTo(Arrays.asList(",", ":"));
    }

    @ValueSource(strings = {"a", "/"})
    @ParameterizedTest
    void 유효한_커스텀_구분자_포함해서_반환한다(String customDelimiter) {
        final String text = "//" + customDelimiter + "\n1:2a3";
        final DelimiterTokenizer delimiterTokenizer = new DelimiterTokenizer(text);
        assertThat(delimiterTokenizer.getDelimiters()).isEqualTo(Arrays.asList(",", ":", customDelimiter));
    }

    @ValueSource(strings = {"\n"})
    @ParameterizedTest
    void 커스텀_구분자로_개행문자가_들어간경우(String customDelimiter) {
        final String text = "//" + customDelimiter + "\n1:2a3";
        final DelimiterTokenizer delimiterTokenizer = new DelimiterTokenizer(text);
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> delimiterTokenizer.getDelimiters());
    }

    @ValueSource(strings = {"//abcd\n1:2:3", "//12\n1:2:3", "//-1\n1:2:3"})
    @ParameterizedTest
    void 구분자_길이가_2이상인_경우(String text) {
        final DelimiterTokenizer delimiterTokenizer = new DelimiterTokenizer(text);
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> delimiterTokenizer.getDelimiters());
    }

    @ValueSource(strings = {"//\n1:2,3"})
    @ParameterizedTest
    void 구분자_길이가_0인_경우(String text) {
        final DelimiterTokenizer delimiterTokenizer = new DelimiterTokenizer(text);
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> delimiterTokenizer.getDelimiters());
    }

    @ValueSource(strings = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"})
    @ParameterizedTest
    void 구분자가_숫자인_경우(String text) {
        final String str = "//" + text + "\n1:2:3";
        final DelimiterTokenizer delimiterTokenizer = new DelimiterTokenizer(str);
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> delimiterTokenizer.getDelimiters());
    }
}
