package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {
    @DisplayName("구분자(,)로 입력된 번호 문자열을 번호 객체로 변환한다.")
    @Test
    void of() {
        assertThat(Number.of("1,3,12,45,20,22")).isEqualTo(new Number(List.of(1, 12, 45, 20, 22, 3)));
    }

    @DisplayName("null 또는 공백문자열이 입력되면 IllegalArgumentException 예외를 발생시킨다.")
    @ParameterizedTest
    @NullSource
    @EmptySource
    void of_when_null_or_empty(String numbers) {
        assertThatThrownBy(() -> Number.of(numbers)).isInstanceOf(IllegalArgumentException.class).hasMessage("Number cannot be null or blank and must be a delimiter(,)");
    }

    @DisplayName("번호 갯수가 6개가 아닌 번호 문자열이 입력되면 IllegalArgumentException 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = { "1,2,3,4,5", "1,2,3,4,5,6,7" })
    void of_when_invalid_count(String numbers) {
        assertThatThrownBy(() -> Number.of(numbers)).isInstanceOf(IllegalArgumentException.class).hasMessage("Number's count must be six.");
    }

    @DisplayName("숫자가 아닌 번호 문자열이 입력되면 IllegalArgumentException 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = { "1,2,3,4,5,aa", "1,2,3,4,'',6", "1,2,3,4,,5" })
    void of_when_invalid_numbers(String numbers) {
        assertThatThrownBy(() -> Number.of(numbers)).isInstanceOf(IllegalArgumentException.class).hasMessage("Only numbers between 1 and 45 are available.");
    }

    @DisplayName("일치하는 번호 갯수를 리턴한다.")
    @ParameterizedTest
    @MethodSource("matchCountSet")
    void matchCount(Number number, Number other, int expected) {
        assertThat(number.matchCount(other)).isEqualTo(expected);
    }

    private static Stream<Arguments> matchCountSet() {
        return Stream.of(
            Arguments.arguments(new Number(List.of(1, 2, 3, 4, 5, 6)), new Number(List.of(1, 2, 3, 4, 5, 6)), 6),
            Arguments.arguments(new Number(List.of(1, 2, 3, 4, 5, 6)), new Number(List.of(7, 8, 9, 10, 11, 12)), 0),
            Arguments.arguments(new Number(List.of(1, 2, 3, 4, 5, 6)), new Number(Collections.emptyList()), 0),
            Arguments.arguments(new Number(List.of(1, 2, 3, 4, 5, 6)), new Number(List.of(1, 2, 6, 7, 8, 9)), 3)
        );
    }
}
