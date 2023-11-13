package calculator.operator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class OperatorTest {
    @ParameterizedTest(name = "2개의 값을 더한다.")
    @CsvSource(value = {"4:2:6", "3:1:4", "7:2:9"}, delimiter = ':')
    void add(int firstInput, int secondInput, int excepted) {
        Operator operator = new AddOperator();
        int result = operator.calculate(firstInput, secondInput);
        Assertions.assertThat(result).isEqualTo(excepted);
    }


    @ParameterizedTest(name = "두개의 값을 뺀다.")
    @CsvSource(value = {"4:2:2", "3:1:2", "7:2:5"}, delimiter = ':')
    void minus(int firstInput, int secondInput, int excepted) {
        Operator operator = new MinusOperator();
        Assertions.assertThat(operator.calculate(firstInput, secondInput)).isEqualTo(excepted);
    }

    @ParameterizedTest(name = "두개의 값을 곱한다.")
    @CsvSource(value = {"4:2:8", "3:1:3", "7:2:14"}, delimiter = ':')
    void multiply(int firstInput, int secondInput, int excepted) {
        Operator operator = new MultiplyOperator();
        Assertions.assertThat(operator.calculate(firstInput, secondInput)).isEqualTo(excepted);
    }

    @ParameterizedTest(name = "두개의 값을 나눈다")
    @CsvSource(value = {"4:2:2", "3:1:3", "8:2:4"}, delimiter = ':')
    void divide(int firstInput, int secondInput, int excepted) {
        Operator operator = new DivideOperator();
        Assertions.assertThat(operator.calculate(firstInput, secondInput)).isEqualTo(excepted);
    }


}