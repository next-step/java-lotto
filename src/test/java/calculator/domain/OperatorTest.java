package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    @Test
    @DisplayName("나눗셈 연산 시 결과 값이 정수로 떨어진다.")
    void divide_int() {
        int actual = Operator.DIVIDE.apply(10, 3);

        int expected = 3;
        assertThat(actual).isEqualTo(expected);
    }
}
