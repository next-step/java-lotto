package me.daeho.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("문자열 덧셈 계산기 파싱 테스트")
class StringAddParserTest {
    @Test
    public void parsing_쉼표() {
        String[] result = StringAddParser.parsing("1,2");

        assertThat(result.length).isEqualTo(2);
        assertAll(() -> {
            assertThat(result[0]).isEqualTo("1");
            assertThat(result[1]).isEqualTo("2");
        });
    }

    @Test
    public void parsing_콤마_또는_쉼표() {
        String[] result = StringAddParser.parsing("1,2:3");

        assertThat(result.length).isEqualTo(3);
        assertAll(() -> {
            assertThat(result[0]).isEqualTo("1");
            assertThat(result[1]).isEqualTo("2");
            assertThat(result[2]).isEqualTo("3");
        });
    }

    @Test
    public void parsing_custom_구분자() {
        String[] result = StringAddParser.parsing("//;\n1;2;3");

        assertThat(result.length).isEqualTo(3);
        assertAll(() -> {
            assertThat(result[0]).isEqualTo("1");
            assertThat(result[1]).isEqualTo("2");
            assertThat(result[2]).isEqualTo("3");
        });
    }

    @Test
    public void parsing_문자하나() {
        String[] result = StringAddParser.parsing("a");

        assertThat(result.length).isEqualTo(1);
        assertThat(result[0]).isEqualTo("a");
    }

    @Test
    public void parsing_음수() {
        String[] result = StringAddParser.parsing("-1,2:-30");

        assertThat(result.length).isEqualTo(3);
        assertAll(() -> {
            assertThat(result[0]).isEqualTo("-1");
            assertThat(result[1]).isEqualTo("2");
            assertThat(result[2]).isEqualTo("-30");
        });
    }
}