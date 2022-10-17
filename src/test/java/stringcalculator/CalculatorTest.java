package stringcalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1, 2, +, 3", "1, 2, -, -1", "1, 2, *, 2", "2, 1, /, 2"})
    void 연산자에_따라_계산한다(int firstNumber, int secondNumber, String arithmetic, int expected) {
        assertThat(new Calculator().calculate(firstNumber, secondNumber, arithmetic)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "#"})
    void 지원되는_연산자가_아니면_예외를_던진다(String source) {
        assertThrows(IllegalArgumentException.class, () -> new Calculator().calculate(1, 2, source));
    }

}
