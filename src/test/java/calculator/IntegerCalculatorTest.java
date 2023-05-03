package calculator;

import calculator.converter.IntegerStringConverter;
import calculator.parser.ExpressionParser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class IntegerCalculatorTest {

    private final String delimiter = " ";
    private IntegerCalculator calculator;

    @BeforeEach
    void setUp() {
        Map<String, Operator> operatorMap = new HashMap<>();
        operatorMap.put("+", new Operator((a, b) -> a + b));
        operatorMap.put("-", new Operator((a, b) -> a - b));
        operatorMap.put("*", new Operator((a, b) -> a * b));
        operatorMap.put("/", new Operator((a, b) -> a / b));

        calculator = new IntegerCalculator(
                new ExpressionParser(delimiter),
                new IntegerStringConverter(),
                new Operators(operatorMap));
    }

    @Test
    void 사칙_연산자_외의_문자가_포함된_경우_예외를_발생시킨다() {
        String expression = "1 + 2 ^ 4";

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.calculate(expression));
    }

    @Test
    void 숫자만이_주어지는_경우_그대로_반환한다() {
        String original = "11";
        int expected = Integer.parseInt(original);

        int res = calculator.calculate(original);
        Assertions.assertThat(res).isEqualTo(expected);
    }

    @Test
    void 곱셈_연산자가_포함된_식_에_대한_곱셈_연산을_수행한다() {
        String expression = "1 * 2 * 3";
        int expected = 1 * 2 * 3;

        int res = calculator.calculate(expression);

        Assertions.assertThat(res).isEqualTo(expected);
    }

    @Test
    void 덧셈_과_곱셈_연산이_포함된_연산을_수행한다() {
        String expression = "1 * 2 + 3";
        int expected = 1 * 2 + 3;

        int res = calculator.calculate(expression);

        Assertions.assertThat(res).isEqualTo(expected);
    }

    @Test
    void 덧셈_과_곱셈_과_뺄셈_연산이_포함된_연산을_수행한다() {
        String expression = "1 * 2 + 3 - 1";
        int expected = 1 * 2 + 3 - 1;

        int res = calculator.calculate(expression);

        Assertions.assertThat(res).isEqualTo(expected);
    }

    @Test
    void 나눗셈_결과는_정수로_나누어_떨어진다() {
        String expression = "3 / 2";
        int expected = 1;

        int res = calculator.calculate(expression);

        Assertions.assertThat(res).isEqualTo(expected);
    }
}
