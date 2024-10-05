package stringcalculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.domain.operator.Multiplication;

import static org.assertj.core.api.Assertions.assertThat;

class MultiplicationTest {
    private Multiplication multiplication;

    @BeforeEach
    void setUp() {
        multiplication = new Multiplication();
    }

    @DisplayName("2과 3를 곱할 수 있다.")
    @Test
    void calculate() {

        int result = multiplication.calculate(2, 3);

        assertThat(result).isEqualTo(6);
    }

    @DisplayName("연산자가 *이면 true를 반환한다.")
    @Test
    void supports() {
        assertThat(multiplication.supports("*")).isTrue();
    }

    @DisplayName("연산자가 *가 아니면 false를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "/"})
    void supportsReturnFalse(String operator) {
        assertThat(multiplication.supports(operator)).isFalse();
    }
}