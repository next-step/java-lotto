package calculator.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorParserTest {

    @DisplayName("input으로 null인 경우 빈 배열 반환")
    @Test
    void splitWithNull() {
        // given & when
        List<String> result = StringCalculatorParser.split(null);

        // then
        assertThat(result).hasSize(0);
    }

    @DisplayName("문자열 계산기 파서 테스트 - 정상 케이스")
    @Test
    void split() {
        // given
        String input = "1 + -1 - 1 * 1 / 1";

        // when
        List<String> result = StringCalculatorParser.split(input);

        // then
        assertThat(result).hasSize(9)
                          .containsExactly("1", "+", "-1", "-", "1", "*", "1", "/", "1");
    }
}