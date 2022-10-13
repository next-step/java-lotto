package stringcalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import stringcalculator.arithmetic.*;

import static org.assertj.core.api.Assertions.assertThat;

class ArithmeticOperationTest {

    @ParameterizedTest
    @CsvSource(value = { "1, 2, 3", "0, 0, 0", "-1, -2, -3" })
    void 덧셈_테스트(int firstNumber, int secondNumber, int expected) {
        ArithmeticOperation operation = new Add();
        assertThat(operation.calculate(firstNumber, secondNumber)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = { "1, 2, -1", "0, 0, 0", "-1, -2, 1" })
    void 뺄셈_테스트(int firstNumber, int secondNumber, int expected) {
        ArithmeticOperation operation = new Sub();
        assertThat(operation.calculate(firstNumber, secondNumber)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = { "1, 2, 2", "0, 0, 0", "-1, -2, 2" })
    void 곱셈_테스트(int firstNumber, int secondNumber, int expected) {
        ArithmeticOperation operation = new Multiply();
        assertThat(operation.calculate(firstNumber, secondNumber)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = { "2, 1, 2", "0, 3, 0", "-2, -1, 2" })
    void 나눗셈_테스트(int firstNumber, int secondNumber, int expected) {
        ArithmeticOperation operation = new Divide();
        assertThat(operation.calculate(firstNumber, secondNumber)).isEqualTo(expected);
    }
}
