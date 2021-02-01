package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringSplitterTest {
    @DisplayName("컴마(,) 구분자로 입력할 경우 문자 배열을 반환")
    @Test
    void parseCommaReturnsStringArray() {
        // given & when
        String[] result = StringSplitter.split("1,2,3");

        // then
        assertThat(result).containsExactly("1", "2", "3");
    }

    @DisplayName("콜론(:) 구분자로 입력할 경우 문자 배열을 반환")
    @Test
    void parseColonReturnsStringArray() {
        // given & when
        String[] result = StringSplitter.split("1:2:3");

        // then
        assertThat(result).containsExactly("1", "2", "3");
    }

    @DisplayName("컴마(,), 콜론(:) 구분자로 입력할 경우 문자 배열을 반환")
    @Test
    void parseCommaAndColonReturnsStringArray() {
        // given & when
        String[] result = StringSplitter.split("1,2:3");

        // then
        assertThat(result).containsExactly("1", "2", "3");
    }

    @DisplayName("//와 \n 문자 분자를 입력할 경우 문자 배열")
    @Test
    void parseCustomReturnsStringArray() {
        // given & when
        String[] result = StringSplitter.split("//;\n1;2;3");

        // then
        assertThat(result).containsExactly("1", "2", "3");
    }
}