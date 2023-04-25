package calculator.operations;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class DivideTest {
    @Test
    void divide() {
        // given
        Divide divide = new Divide();

        //when
        int result = divide.apply(10, 2);

        //then
        assertThat(result).isEqualTo(5);
    }

    @ParameterizedTest
    @DisplayName("0으로 나누거나 나눈 값이 정수가 아닐경우 예외 발생")
    @CsvSource({"1, 0", "11, 2", "3, 2", "-4, 3"})
    void when_PrecedingValueIsNotInt_ThrowException(int a, int b) {
        // given
        Divide divide = new Divide();

        // when, then
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> divide.apply(a, b));
    }
}