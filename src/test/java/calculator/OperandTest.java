package calculator;

import calculator.domain.Operand;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperandTest {
    @ParameterizedTest
    @CsvSource(value = {"3,3", "-2,-2", "0,0", "-1,-1"})
    void 올바른_피연산자_생성(String input, int expected) {
        Operand operand = new Operand(input);
        assertThat(operand.value()).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " ", "1.2", "+", "-", "*", "/"})
    void 올바르지_않은_피연산자_생성(String input) {
        assertThatThrownBy(() -> new Operand(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
