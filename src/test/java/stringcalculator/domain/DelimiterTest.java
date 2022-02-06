package stringcalculator.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DelimiterTest {

    @DisplayName("구분자의 시작과 끝은 숫자이면 예외를 발생시킨다.")
    @ValueSource(strings = {"3a3", "123", "22a", "aa3"})
    @ParameterizedTest
    void Given_시작이나_끝이_숫자인_구분자_When_객체_생성_Then_예외_발생(final String input) {

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Delimiter(input));
    }
}
