package stringcalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimitersTest {

    @DisplayName("기본 구분자라면 구분자들을 String 으로 연결하고, []안에 넣어 반환한다.")
    @Test
    void When_기본_구분자_toString_Then_구분자를_문자열로_연결하여_중괄호_안에_담아_반환() {
        final Delimiters delimiters = new Delimiters("");

        final String actual = delimiters.getValuesToRegex();

        assertThat(actual).isEqualTo("[:,]");
    }

    @DisplayName("커스텀 구분자라면 구분자들을 String 으로 연결하고, 반환한다.")
    @Test
    void When_커스텀_구분자_toString_Then_구분자를_문자열로_연결하여_반환() {
        final Delimiters delimiters = new Delimiters("aaa");

        final String actual = delimiters.getValuesToRegex();

        assertThat(actual).isEqualTo("aaa");
    }
}
