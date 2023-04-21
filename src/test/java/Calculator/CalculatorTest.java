package Calculator;

import Calculator.Model.Calculator;
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
        String expected = "3";
        calculator.execute("2", "+", "1");
        String actual = calculator.currentResult();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("execute 뺄셈 정상 확인")
    public void execute_subtract() {
        String expected = "1";
        calculator.execute("2", "-", "1");
        String actual = calculator.currentResult();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("execute 곱셈 정상 확인")
    public void execute_multiple() {
        String expected = "6";
        calculator.execute("3", "*", "2");
        String actual = calculator.currentResult();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("execute 나눗셈 정상 확인")
    public void execute_divide() {
        String expected = "2";
        calculator.execute("10", "/", "5");
        String actual = calculator.currentResult();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("type 숫자 입력")
    public void type_number() {
        String expected = "5";

        calculator.type("5");
        String actual = calculator.currentResult();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("type 숫자 입력2")
    public void type_numbertest() {
        String expected = "10";

        calculator.type("10");
        String actual = calculator.currentResult();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("type Operator 입력")
    public void type_oprator() {
        String expected = "-";

        calculator.type("-");
        String actual = calculator.currentOpretor();
        assertThat(actual).isEqualTo(expected);
    }
}
