package calculator.view;

import calculator.Operator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void isOperator(String operator) {
        boolean actual = Operator.isOperator(operator);

        assertThat(actual).isTrue();
    }
}