package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class NumberTest {

    @DisplayName("숫자의 빈 값 또는 Null 값이 들어오면 익셉션 처리한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void number_null_empty(final String input) {

        assertThatThrownBy(() -> new Number(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값이 null 또는 빈 공백 입니다.");

    }

    @DisplayName("숫자 대신 문자(연산자포함) 들어오면 익셉션 처리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "D", "+", "-"})
    void number_string(final String input) {

        assertThatThrownBy(() -> new Number(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("계산기를 잘못 입력하였습니다.");
    }
}