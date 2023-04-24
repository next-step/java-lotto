package calculator.Model;

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

        calculator.execute(2, "+", 1);
        int actual = calculator.currentResult();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("execute 뺄셈 정상 확인")
    public void execute_subtract() {
        int expected = 1;

        calculator.execute(2, "-", 1);
        int actual = calculator.currentResult();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("execute 곱셈 정상 확인")
    public void execute_multiple() {
        int expected = 6;

        calculator.execute(3, "*", 2);
        int actual = calculator.currentResult();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("execute 나눗셈 정상 확인")
    public void execute_divide() {
        int expected = 2;

        calculator.execute(10, "/", 5);
        int actual = calculator.currentResult();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("type 숫자 입력")
    public void type_number() {
        int expected = 5;

        calculator.type("5");
        int actual = calculator.currentResult();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("type  입력")
    public void type_oprator() {
        String expected = "-";

        calculator.type("-");
        String actual = calculator.currentOperator();
        assertThat(actual).isEqualTo(expected);
    }
}
