package step1.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorTest {

    @Test
    @DisplayName("사칙연산 기호에 대한 열거값")
    void getEnum() {
        assertThat(Operator.of("+")).isEqualTo(Operator.ADD);
        assertThat(Operator.of("-")).isEqualTo(Operator.SUBTRACT);
        assertThat(Operator.of("*")).isEqualTo(Operator.MULTIPLY);
        assertThat(Operator.of("/")).isEqualTo(Operator.DIVIDE);
    }

    @ParameterizedTest(name = "지원하지 않는 연산자 입력이 주어질 때 예외: {0}")
    @ValueSource(strings = {"!", "-=", "hello"})
    void getEnumWithInvalidInput(String operator) {
        assertThatThrownBy(() -> Operator.of(operator))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("허용하지 않는 사칙연산 기호입니다");
    }

    @ParameterizedTest(name = "사칙연산 열거형에 대한 연산 수행")
    @CsvSource(value = {
        "ADD, 1, 2, 3",
        "SUBTRACT, 3, 2, 1",
        "MULTIPLY, 3, 5, 15",
        "DIVIDE, 10, 5, 2"
    })
    void calculate(Operator operator, int left, int right, int expected) {
        assertThat(operator.calculate(new Number(left), new Number(right))).isEqualTo(new Number(expected));
    }
}
