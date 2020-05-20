package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTests {
    @DisplayName("양수 문자열을 입력받아서 객체를 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "5"})
    void numberCreateTest(String input) {
        Number number = new Number(input);
        assertThat(number).isNotNull();
    }

    @DisplayName("음수 문자열을 입력 받으면 RuntimeException을 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-100"})
    void numberCreateFailWithNegativeNumberString(String invalidInput) {
        assertThatThrownBy(() -> new Number(invalidInput)).isInstanceOf(RuntimeException.class);
    }
}
