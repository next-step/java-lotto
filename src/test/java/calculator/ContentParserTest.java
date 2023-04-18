package calculator;

import calculator.domain.Content;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class ContentParserTest {

    @Test
    @DisplayName("공백으로 구분된 문자열이 들어오면, 숫자와 사칙 연산을 순차적으로 반환한다.")
    public void parse() {
        ContentParser contentParser = new ContentParser("2 + 3 * 4 / 2");
        List<Content> list = new ArrayList<>();
        list.add(new Content(2));
        list.add(new Content("+"));
        list.add(new Content(3));
        list.add(new Content("*"));
        list.add(new Content(4));
        list.add(new Content("/"));
        list.add(new Content(2));

        assertThat(contentParser.parse()).containsAll(list);
    }

    @Test
    @DisplayName("입력값이 null이거나 빈 공백 문자열인 경우 예외를 반환한다.")
    public void throw_exception_when_parse_fail() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new ContentParser("");
                }).withMessageMatching("입력값이 null이거나 빈 공백 문자입니다.");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new ContentParser(null);
                }).withMessageMatching("입력값이 null이거나 빈 공백 문자입니다.");
    }
}
