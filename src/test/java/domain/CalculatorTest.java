package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    Calculator calculator = new Calculator();

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

    @DisplayName("숫자와 연산기호를 순서대로 입력해서 결과 도출")
    @Test
    void calculateResult() {
        assertThat(calculator.operate(numbers, signs)).isEqualTo(3);
    }
}