package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTest {

    @ParameterizedTest
    @DisplayName("사칙연산 검증")
    @CsvSource(
            delimiter = ':',
            value = {
                    "+:5:3:8",
                    "-:5:3:2",
                    "*:5:3:15",
                    "/:10:5:2"
            }
    )
    void basicOperate(String operator, int number1, int number2, int expected) {
        assertThat(Operator.from(operator).execute(number1, number2)).isEqualTo(expected);
    }

    @Test
    @DisplayName("사칙 연산자 외 다른 연산자 검증")
    void operateDivideDecimalException() {
        assertThatThrownBy(() -> Operator.from("$").execute(10, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("0으로 나누면 예외 발생")
    void operateDivide() {
        assertThatThrownBy(() -> {
            Operator.DIVIDE.execute(10, 0);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
