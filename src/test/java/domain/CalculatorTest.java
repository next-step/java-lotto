package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    String plusSymbol;
    String minusSymbol;
    String multiplySymbol;
    String divideSymbol;

    int leftOperand;
    int rightOperand;

    List<String> numbers = new ArrayList<>();
    List<String> signs = new ArrayList<>();

    @BeforeEach
    void setUp() {
        plusSymbol = "+";
        minusSymbol = "-";
        multiplySymbol = "*";
        divideSymbol = "/";

        leftOperand = 10;
        rightOperand = 2;

        numbers.add("10");
        numbers.add("5");
        numbers.add("5");

        signs.add("+");
        signs.add("/");
    }

    @Test
    public void 숫자와_연산기호_배열_입력시_결과_도출() {
        assertThat(Calculator.operate(numbers, signs)).isEqualTo(3);
    }

    @Test
    public void 연산_기호에_따른_계산() {
        assertThat(Calculator.calculate(plusSymbol, leftOperand, rightOperand)).isEqualTo(12);
        assertThat(Calculator.calculate(minusSymbol, leftOperand, rightOperand)).isEqualTo(8);
        assertThat(Calculator.calculate(multiplySymbol, leftOperand, rightOperand)).isEqualTo(20);
        assertThat(Calculator.calculate(divideSymbol, leftOperand, rightOperand)).isEqualTo(5);
    }

    @Test
    public void 더하기_계산() {
        assertThat(Calculator.plus(leftOperand, rightOperand)).isEqualTo(12);
    }

    @Test
    public void 빼기_계산() {
        assertThat(Calculator.minus(leftOperand, rightOperand)).isEqualTo(8);
    }

    @Test
    public void 곱하기_계산() {
        assertThat(Calculator.multiply(leftOperand, rightOperand)).isEqualTo(20);
    }

    @Test
    public void 나누기_계산() {
        assertThat(Calculator.divide(leftOperand, rightOperand)).isEqualTo(5);
    }
}