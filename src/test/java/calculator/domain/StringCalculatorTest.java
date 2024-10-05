package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    void 빈_또는_null() {
        assertThatThrownBy(() -> new StringCalculator().splitAndCalculate(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new StringCalculator().splitAndCalculate(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 합계_2개_피연산자() {
        StringCalculator calculator = new StringCalculator();
        String firstExpr = "1 + 1";
        String secondExpr = "1 + 4";

        int firstResult = calculator.splitAndCalculate(firstExpr);
        int secondResult = calculator.splitAndCalculate(secondExpr);

        assertThat(firstResult).isEqualTo(2);
        assertThat(secondResult).isEqualTo(5);
    }

    @Test
    void 합계_여러개_피연산자() {
        StringCalculator calculator = new StringCalculator();
        String firstExpr = "1 + 1 + 1";
        String secondExpr = "1 + 4 + 5 + 10";

        int firstResult = calculator.splitAndCalculate(firstExpr);
        int secondResult = calculator.splitAndCalculate(secondExpr);

        assertThat(firstResult).isEqualTo(3);
        assertThat(secondResult).isEqualTo(20);
    }

    @Test
    void 뺄셈_2개_피연산자() {
        StringCalculator calculator = new StringCalculator();
        String firstExpr = "1 - 1";
        String secondExpr = "5 - 4";
        String thirdExpr = "1 - 4";

        int firstResult = calculator.splitAndCalculate(firstExpr);
        int secondResult = calculator.splitAndCalculate(secondExpr);
        int thirdResult = calculator.splitAndCalculate(thirdExpr);

        assertThat(firstResult).isEqualTo(0);
        assertThat(secondResult).isEqualTo(1);
        assertThat(thirdResult).isEqualTo(-3);
    }

    @Test
    void 뺄셈_여러개_피연산자() {
        StringCalculator calculator = new StringCalculator();
        String firstExpr = "1 - 1 - 1";
        String secondExpr = "10 - 1 - 4 - 50";

        int firstResult = calculator.splitAndCalculate(firstExpr);
        int secondResult = calculator.splitAndCalculate(secondExpr);

        assertThat(firstResult).isEqualTo(-1);
        assertThat(secondResult).isEqualTo(-45);
    }

    @Test
    void 곱하기_2개_피연산자() {
        StringCalculator calculator = new StringCalculator();
        String firstExpr = "1 * 1";
        String secondExpr = "1 * 4";

        int firstResult = calculator.splitAndCalculate(firstExpr);
        int secondResult = calculator.splitAndCalculate(secondExpr);

        assertThat(firstResult).isEqualTo(1);
        assertThat(secondResult).isEqualTo(4);
    }

    @Test
    void 곱하기_여러개_피연산자() {
        StringCalculator calculator = new StringCalculator();
        String firstExpr = "1 * 1 * 3";
        String secondExpr = "1 * 4 * 5 * 10";

        int firstResult = calculator.splitAndCalculate(firstExpr);
        int secondResult = calculator.splitAndCalculate(secondExpr);

        assertThat(firstResult).isEqualTo(3);
        assertThat(secondResult).isEqualTo(200);
    }

    @Test
    void 나누기_2개_피연산자() {
        StringCalculator calculator = new StringCalculator();
        String firstExpr = "1 / 1";
        String secondExpr = "1 / 4";

        int firstResult = calculator.splitAndCalculate(firstExpr);
        int secondResult = calculator.splitAndCalculate(secondExpr);

        assertThat(firstResult).isEqualTo(1);
        assertThat(secondResult).isEqualTo(0);
    }

    @Test
    void 나누기_여러개_피연산자() {
        StringCalculator calculator = new StringCalculator();
        String firstExpr = "20 / 4";
        String secondExpr = "20 / 4 / 5";

        int firstResult = calculator.splitAndCalculate(firstExpr);
        int secondResult = calculator.splitAndCalculate(secondExpr);

        assertThat(firstResult).isEqualTo(5);
        assertThat(secondResult).isEqualTo(1);
    }

    @Test
    void 나누기_0_에러() {
        StringCalculator calculator = new StringCalculator();
        String firstExpr = "20 / 0";

        assertThatThrownBy(() -> calculator.splitAndCalculate(firstExpr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사칙연산() {
        StringCalculator calculator = new StringCalculator();
        String firstExpr = "1 + 1 * 3 / 5 - 20";
        String secondExpr = "1 * 4 - 5 * 10 + 1 / 10";

        int firstResult = calculator.splitAndCalculate(firstExpr);
        int secondResult = calculator.splitAndCalculate(secondExpr);

        assertThat(firstResult).isEqualTo(-19);
        assertThat(secondResult).isEqualTo(0);
    }

    @Test
    void 잘못된_연산자() {
        StringCalculator calculator = new StringCalculator();
        String expr = "1 ) 1 * 3 / 5 - 20";

        assertThatThrownBy(() -> calculator.splitAndCalculate(expr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 피연산자_숫자_아님() {
        StringCalculator calculator = new StringCalculator();
        String expr = "1 + a * 3 / 5 - 20";

        assertThatThrownBy(() -> calculator.splitAndCalculate(expr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 첫번째_문자_숫자_아님() {
        StringCalculator calculator = new StringCalculator();
        String expr = "/ 2 / 1";

        assertThatThrownBy(() -> calculator.splitAndCalculate(expr))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    void 마지막_문자_숫자_아님() {
        StringCalculator calculator = new StringCalculator();
        String expr = "1 / 2 /";
        assertThatThrownBy(() -> calculator.splitAndCalculate(expr))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    void 숫자_뒤에_숫자() {
        StringCalculator calculator = new StringCalculator();
        String expr = "1 2 / 4";

        assertThatThrownBy(() -> calculator.splitAndCalculate(expr))
                .isInstanceOf(IllegalArgumentException.class);
    }
}