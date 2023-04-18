package Calculator;

import Calculator.View.InputView;
import Calculator.Model.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCalculator {
    Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("callCalculator 덧셈 정상 확인")
    public void callCalculator_add() {
        String expected = "1";
        String actual = calculator.callCalculator("0", "+", "1");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("callCalculator 뺄셈 정상 확인")
    public void callCalculator_subtract() {
        String expected = "1";
        String actual = calculator.callCalculator("2", "-", "1");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("callCalculator 곱셈 정상 확인")
    public void callCalculator_multiple() {
        String expected = "6";
        String actual = calculator.callCalculator("3", "*", "2");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("callCalculator 나눗셈 정상 확인")
    public void callCalculator_divide() {
        String expected = "2";
        String actual = calculator.callCalculator("10", "/", "5");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("calculator 숫자 입력")
    public void calculator_number() {
        String expected = "2";

        ArrayList<String> input = new ArrayList<>();
        input.add("10");
        input.add("/");
        input.add("5");
        ArrayList<String> actual = calculator.calculate(input);
        assertThat(calculator.getCurrentResult(actual)).isEqualTo(expected);
    }

    @Test
    @DisplayName("calculator Operator 입력")
    public void calculator_oprator() {
        String expected = "-";

        ArrayList<String> input = new ArrayList<>();
        input.add("10");
        input.add("/");
        input.add("-");
        ArrayList<String> actual = calculator.calculate(input);
        assertThat(calculator.getCurrentOpretor(actual)).isEqualTo(expected);
    }
}
