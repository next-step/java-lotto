package stringcalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimitersTest {

    @DisplayName("공백이 들어오면 기본 구분자로 생성한다.")
    @Test
    void Given_공백_When_구분자_객체_생성_Then_기본_구분자로_생성() {
        final List<String> expected = Arrays.asList(":", ",");
        final Delimiters delimiters = new Delimiters("");

        final String actual = delimiters.getValuesToString();

        assertThat(actual).isEqualTo(String.join("", expected));
    }

    @DisplayName("구분자들을 String 으로 연결하여 반환한다.")
    @Test
    void When_구분자_toString_Then_구분자를_문자열로_연결하여_반환() {
        final Delimiters delimiters = new Delimiters("");

        final String actual = delimiters.getValuesToString();

        assertThat(actual).isEqualTo(":,");
    }

    @DisplayName("커스텀 구분자 생성")
    @Test
    void Given_커스텀_구분자_When_구분자_객체_생성_Then_커스텀_구분자_생성() {
        String inputCustomDelimiter = "ab";
        final Delimiters delimiters = new Delimiters(inputCustomDelimiter);

        final String actual = delimiters.getValuesToString();

        assertThat(actual).isEqualTo(inputCustomDelimiter);
    }
}
