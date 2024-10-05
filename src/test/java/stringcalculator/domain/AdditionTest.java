package stringcalculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.domain.operator.Addition;

import static org.assertj.core.api.Assertions.assertThat;

class AdditionTest {
    private Addition addition;

    @BeforeEach
    void setUp() {
        addition = new Addition();
    }

    @DisplayName("1과 2를 더할 수 있다.")
    @Test
    void calculate() {

        int result = addition.calculate(1, 2);

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("연산자가 *이면 true를 반환한다.")
    @Test
    void supports() {
        assertThat(addition.supports("+")).isTrue();
    }

    @DisplayName("연산자가 *가 아니면 false를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-", "*", "/"})
    void supportsReturnFalse(String operator) {
        assertThat(addition.supports(operator)).isFalse();
    }
}