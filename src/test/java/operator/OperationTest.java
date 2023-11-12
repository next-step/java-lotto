package operator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperationTest {
    @ParameterizedTest(name = "2개의 값을 더한다.")
    @CsvSource(value = {"4:2:6", "3:1:4", "7:2:9"}, delimiter = ':')
    void add(int firstInput, int secondInput, int excepted) {
        Operation operation = new AddOperation();
        assertThat(operation.calculate(firstInput, secondInput)).isEqualTo(excepted);
    }

    @ParameterizedTest(name = "두개의 값을 뺀다.")
    @CsvSource(value = {"4:2:2", "3:1:2", "7:2:5"}, delimiter = ':')
    void minus(int firstInput, int secondInput, int excepted) {
        Operation operation = new SubtractOperation();
        assertThat(operation.calculate(firstInput, secondInput)).isEqualTo(excepted);
    }

    @ParameterizedTest(name = "두개의 값을 곱한다.")
    @CsvSource(value = {"4:2:8", "3:1:3", "7:2:14"}, delimiter = ':')
    void multiply(int firstInput, int secondInput, int excepted) {
        Operation operation = new MultiplyOperation();
        assertThat(operation.calculate(firstInput, secondInput)).isEqualTo(excepted);
    }

    @ParameterizedTest(name = "두개의 값을 나눈다")
    @CsvSource(value = {"4:2:2", "3:1:3", "8:2:4"}, delimiter = ':')
    void divide(int firstInput, int secondInput, int excepted) {
        Operation operation = new DivideOperation();
        assertThat(operation.calculate(firstInput, secondInput)).isEqualTo(excepted);
    }

    @ParameterizedTest(name = "연산자를 읽어서 연산을 생성한다.")
    @ValueSource(strings = {"+", "-", "*", "/"})
    void create_operation(String input) {
        assertThat(Operation.fromSymbol(input)).isInstanceOf(Operation.class);
    }

    @ParameterizedTest(name = "연산자가 아닌 경우 예외를 발생시킨다.")
    @ValueSource(strings = {"1", "text"})
    void validaion_operator(String input) {
        assertThatThrownBy(() ->Operation.fromSymbol(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}