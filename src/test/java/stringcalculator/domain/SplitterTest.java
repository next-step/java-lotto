package stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SplitterTest {

    @DisplayName("기본 구분자 ',' 로 문자열을 분리한다.")
    @Test
    void splitCommaDelimiter() {
        String expression = "1,3,5";

        List<String> splits = Splitter.split(expression);

        assertThat(splits).isEqualTo(Arrays.asList("1", "3", "5"));
    }

    @DisplayName("기본 구분자 ':' 로 문자열을 분리한다.")
    @Test
    void splitColonDelimiter() {
        String expression = "3:2:5";

        List<String> splits = Splitter.split(expression);

        assertThat(splits).isEqualTo(Arrays.asList("3", "2", "5"));
    }

    @DisplayName("기본 구분자 ',' ':' 두개로 문자열을 분리한다.")
    @Test
    void splitDefaultDelimiter() {
        String expression = "1,10:3";

        List<String> splits = Splitter.split(expression);

        assertThat(splits).isEqualTo(Arrays.asList("1", "10", "3"));
    }

    @DisplayName("커스텀 구분자로 문자열을 분리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//&\n1&2&3"})
    void splitCustomDefaultDelimiter(String expression) {
        List<String> splits = Splitter.split(expression);

        assertThat(splits).isEqualTo(Arrays.asList("1", "2", "3"));
    }
}