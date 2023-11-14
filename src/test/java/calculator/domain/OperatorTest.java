package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    @ParameterizedTest
    @CsvSource(value = {"2,3,5", "50,4,54", "35,10,45"})
    void plus(int x, int y, int expected) {
        int actual = Operator.PLUS.apply(x, y);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2,3,-1", "50,4,46", "35,10,25"})
    void minus(int x, int y, int expected) {
        int actual = Operator.MINUS.apply(x, y);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2,3,6", "50,4,200", "3,10,30"})
    void multiply(int x, int y, int expected) {
        int actual = Operator.MULTIPLY.apply(x, y);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("나눗셈 연산 시 결과 값이 정수로 떨어진다.")
    void divide_int() {
        int actual = Operator.DIVIDE.apply(10, 3);

        int expected = 3;
        assertThat(actual).isEqualTo(expected);
    }
}
