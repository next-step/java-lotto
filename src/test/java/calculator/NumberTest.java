package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {
    @DisplayName("String 값으로 Number 객체를 생성한다. getNumber는 멤버 변수 number 값(int)을 반환한다. ")
    @ParameterizedTest
    @CsvSource(value = {"1, 1", "2, 2", "3, 3"})
    void create(String token, int expected) {
        assertThat(new Number(token).getNumber()).isEqualTo(expected);
    }

    @DisplayName("Number 생성자에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-2", "@", "#", "text"})
    void exception(String token) {
        assertThatThrownBy(() -> new Number(token)).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("add 함수는 멤버 변수 number를 덧셈하고 새 Number를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1, 1, 2", "2, 2, 4", "3, 3, 6"})
    void add(String token1, String token2, int expected) {
        // given
        Number number1 = new Number(token1);
        Number number2 = new Number(token2);

        // when
        Number result = number1.add(number2);

        // then
        assertThat(result.getNumber()).isEqualTo(expected);
    }
}
