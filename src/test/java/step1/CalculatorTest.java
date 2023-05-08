package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step1.domain.calculator.Calculator;
import step1.domain.expression.Expression;
import step1.domain.expression.ExpressionFactory;
import step1.domain.num.Num;
import step1.domain.num.Nums;
import step1.domain.operator.Operator;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest(name = "연산")
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    void calculate_multiExpression(String input) {
        String[] strings = input.split(" ");

        calculator.calculate(new Nums(new Num(strings[0]), new Num(strings[2])), ExpressionFactory.of(new Operator(strings[1])));
        calculator.calculate(new Num(strings[4]), ExpressionFactory.of(new Operator(strings[3])));
        calculator.calculate(new Num(strings[6]), ExpressionFactory.of(new Operator(strings[5])));

        assertThat(calculator.result()).isEqualTo(new Num(10));
    }

    @ParameterizedTest(name = "덧셈")
    @ValueSource(strings = {"2 + 3"})
    void calculate_addition(String input) {
        calculate(input.split(" "));
        assertThat(calculator.result()).isEqualTo(new Num(5));
    }

    @ParameterizedTest(name = "뺄셈")
    @ValueSource(strings = {"2 - 3"})
    void calculate_subtraction(String input) {
        calculate(input.split(" "));
        assertThat(calculator.result()).isEqualTo(new Num(-1));
    }

    @ParameterizedTest(name = "곱셈")
    @ValueSource(strings = {"3 * 4"})
    void calculate_multiplication(String input) {
        calculate(input.split(" "));
        assertThat(calculator.result()).isEqualTo(new Num(12));
    }

    @ParameterizedTest(name = "나눗셈")
    @ValueSource(strings = {"4 / 2"})
    void calculate_division(String input) {
        calculate(input.split(" "));
        assertThat(calculator.result()).isEqualTo(new Num(2));
    }

    private void calculate(String[] strings) {
        Num firstNum = new Num(strings[0]);
        Num secondNum = new Num(strings[2]);
        Nums nums = new Nums(firstNum, secondNum);
        Expression expression = ExpressionFactory.of(new Operator(strings[1]));
        calculator.calculate(nums, expression);
    }
}
