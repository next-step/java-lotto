package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {
    @Test
    @DisplayName("문자열 나누기 null 체크")
    void split_null_체크() {
        String input = "";
        Parser parser = new Parser();

        assertThatThrownBy(() ->  parser.split(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력값이 비어있습니다");
    }
    @Test
    @DisplayName("문자열 나누기 성공")
    void split_성공() {
        String input = "2 + 3 * 4 / 2";
        Parser parser = new Parser();

        List<String> result = parser.split(input);

        assertThat(result).isEqualTo(List.of("2", "+", "3", "*", "4", "/", "2"));

    }
}
