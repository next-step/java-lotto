package calculator.Model;

import calculator.Enums.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("execute 덧셈 정상 확인")
    public void execute_add() {
        int expected = 3;

        Number numberBefore = new Number("2");
        Number numberAfter = new Number("1");
        Operator operatorAdd = Operator.of("+");

        Number actualNumber = calculator.calculate(numberBefore, operatorAdd, numberAfter);
        int actual = actualNumber.value();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("execute 뺄셈 정상 확인")
    public void execute_subtract() {
        int expected = 1;

        Number numberBefore = new Number("2");
        Number numberAfter = new Number("1");
        Operator operator = Operator.of("-");

        Number actualNumber = calculator.calculate(numberBefore, operator, numberAfter);
        int actual = actualNumber.value();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("execute 곱셈 정상 확인")
    public void execute_multiple() {
        int expected = 2;

        Number numberBefore = new Number("2");
        Number numberAfter = new Number("1");
        Operator operator = Operator.of("*");

        Number actualNumber = calculator.calculate(numberBefore, operator, numberAfter);
        int actual = actualNumber.value();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("execute 나눗셈 정상 확인")
    public void execute_divide() {
        int expected = 2;

        Number numberBefore = new Number("10");
        Number numberAfter = new Number("5");
        Operator operator = Operator.of("/");

        Number actualNumber = calculator.calculate(numberBefore, operator, numberAfter);
        int actual = actualNumber.value();
        assertThat(actual).isEqualTo(expected);
    }

}
