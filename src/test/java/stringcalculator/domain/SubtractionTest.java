package stringcalculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.domain.operator.Subtraction;

import static org.assertj.core.api.Assertions.assertThat;

class SubtractionTest {
    private Subtraction subtraction;

    @BeforeEach
    void setUp() {
        subtraction = new Subtraction();
    }

    @DisplayName("2과 1를 뺄 수 있다.")
    @Test
    void calculate() {

        int result = subtraction.calculate(2, 1);

        assertThat(result).isEqualTo(1);
    }

    @DisplayName("연산자가 -이면 true를 반환한다.")
    @Test
    void supports() {
        assertThat(subtraction.supports("-")).isTrue();
    }

    @DisplayName("연산자가 -가 아니면 false를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"+", "*", "/"})
    void supportsReturnFalse(String operator) {
        assertThat(subtraction.supports(operator)).isFalse();
    }
}