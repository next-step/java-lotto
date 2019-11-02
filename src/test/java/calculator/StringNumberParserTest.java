package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringNumberParserTest {
    @Test
    @DisplayName("문자열을 , 와 : 로 구분한다")
    void parse() {
        String expectedString = "1,2,3";
        List<Integer> number = StringNumberParser.parse(expectedString);
        assertThat(number).hasSize(3);
    }

    @Test
    @DisplayName("문자열에 // 와 \n 이 포함되어 있으면 // 와 \n 사이에 있는 문자를 구분자로 사용한다")
    void parseByCustomSeparator() {
        String expectedString = "//;\n1;2;3";
        List<Integer> number = StringNumberParser.parse(expectedString);
        assertThat(number).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,-1,3", "f,2,3"})
    @DisplayName("숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다")
    void validate(String expectedString) {
        assertThatThrownBy(() -> StringNumberParser.parse(expectedString))
                .isInstanceOf(RuntimeException.class);
    }
}
