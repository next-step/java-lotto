package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @DisplayName("유효하지 않은 범위의 숫자가 생성자로 전달될 때 예외를 던지는지 검증")
    @ParameterizedTest
    @ValueSource(ints = { -1, 50 })
    void numberConstructorTest(int input) {
        assertThatThrownBy(() -> new Number(input)).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("유효하지 않은 범위의 문자열 숫자가 생성자로 전달될 때 예외를 던지는지 검증")
    @ParameterizedTest
    @ValueSource(strings = { "-1", "50" })
    void stringNumberConstructorTest(String input) {
        assertThatThrownBy(() -> new Number(input)).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("Number의 생성자에 문자로 전달된 값을 변환하는지 검증")
    @Test
    void stringNumberConstructorTest() {
        assertThat(new Number("10")).isEqualTo(new Number(10));
    }

    @DisplayName("0보다 작은 값으로 Number를 생성하면 예외를 던진다")
    @Test
    void negetiveNumberTest() {
        assertThatThrownBy(() -> new Number(-1)).isInstanceOf(RuntimeException.class);
    }
}
