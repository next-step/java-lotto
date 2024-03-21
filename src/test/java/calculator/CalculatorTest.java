package calculator;

import calculator.model.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    private Calculator calculator;
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    @Test
    @DisplayName("덧셈")
    void addition() {
        int calculationResult = new Calculator().calculateExpression("1 + 3");

        assertThat(calculationResult).isEqualTo(4);
    }

    @Test
    @DisplayName("뺄셈")
    void substraction() {
        int calculationResult = new Calculator().calculateExpression("10 - 2");

        assertThat(calculationResult).isEqualTo(8);
    }

    @Test
    @DisplayName("곱셈")
    void multiplication() {
        int calculationResult = new Calculator().calculateExpression("2 * 9");

        assertThat(calculationResult).isEqualTo(18);
    }
    @Test
    @DisplayName("나눗셈")
    void division() {
        int calculationResult = new Calculator().calculateExpression("36 / 6");

        assertThat(calculationResult).isEqualTo(6);
    }

    @Test
    @DisplayName("나눗셈 연산 결과가 정수가 아닐 경우, 에러 발생 테스트")
    void division_int() {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Calculator().calculateExpression("7 / 2"));

        System.out.println(exception.getMessage());
    }

    @Test
    @DisplayName("0으로 나눗셈 연산을 할 경우, 에러 발생 테스트")
    void division_zero() {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Calculator().calculateExpression("15 / 0"));

        System.out.println(exception.getMessage());
    }



}
