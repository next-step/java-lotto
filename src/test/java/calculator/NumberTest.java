package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NumberTest {

    @DisplayName("숫자 값 객체를 생성한다.")
    @Test
    void create() {
        Number number = Number.valueOf("1");

        Number expect = Number.valueOf("1");

        assertThat(number).isEqualTo(expect);
    }

    @DisplayName("숫자가 아니면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"!", "a", " ", ""})
    void invalid(String input) {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(
                () -> Number.valueOf(input)
        );
    }

    @DisplayName("음수 일 경우 예외를 발생시킨다.")
    @Test
    void checkNegative() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(
                () -> Number.valueOf("-1")
        );
    }
}
