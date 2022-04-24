package calculator.model;

import calculator.util.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.util.Operator.Symbol;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class OperatorTest {

    @Test
    @DisplayName("연산자 별 계산")
    void calculator() {
        int left = 1;
        int right = 2;

        assertAll(
                () -> assertThat(Operator.operator(Symbol.ADDITION).apply(left, right)).isEqualTo(3),
                () -> assertThat(Operator.operator(Symbol.SUBTRACTION).apply(left, right)).isEqualTo(-1),
                () -> assertThat(Operator.operator(Symbol.MULTIPLICATION).apply(left, right)).isEqualTo(2),
                () -> assertThat(Operator.operator(Symbol.DIVISION).apply(left, right)).isEqualTo(0)
        );
    }
}