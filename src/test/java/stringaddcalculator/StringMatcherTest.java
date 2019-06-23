package stringaddcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringMatcherTest {

    @Test
    @DisplayName("문자열이 빈값인경우를 확인한다")
    void checkEmptyString() {
        // when
        StringMatcher stringMatcher = StringMatcher.of("");
        // then
        assertThat(stringMatcher.getDelimeter()).isEqualTo(",|:");
        assertThat(stringMatcher.getNumbers().length()).isEqualTo(0);
    }

    @Test
    @DisplayName("기본 구분자로 처리되는지 확인한다")
    void checkDefaultDelimeter() {
        // when
        StringMatcher stringMatcher = StringMatcher.of("1,2:3");
        // then
        assertThat(stringMatcher.getDelimeter()).isEqualTo(",|:");
        assertThat(stringMatcher.getNumbers()).isEqualTo("1,2:3");
    }

    @Test
    @DisplayName("커스텀 구분자로 처리되는지 확인한다")
    void checkCustomDelimeter() {
        // when
        StringMatcher stringMatcher = StringMatcher.of("//;\n1;2;3;4;5");
        // then
        assertThat(stringMatcher.getDelimeter()).isEqualTo(";");
        assertThat(stringMatcher.getNumbers()).isEqualTo("1;2;3;4;5");
    }
}
