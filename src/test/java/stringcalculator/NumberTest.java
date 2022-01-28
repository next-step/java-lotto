package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyTest(final String userInput) {
        Number number = new Number(userInput);
        assertThat(number.getNumber()).isEqualTo("0");
    }

    @DisplayName("빈 문자열 또는 null이 아닐경우 문자열을 반환")
    @ParameterizedTest
    @ValueSource(strings = {"123:456,789"})
    void 빈_문자열_또는_null_이_아닐경우_문자열을_반환(final String userInput) {
        Number number = new Number(userInput);
        assertThat(number.getNumber()).isEqualTo(userInput);
    }

}
