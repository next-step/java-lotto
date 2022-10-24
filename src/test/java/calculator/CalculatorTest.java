package calculator;

import calculator.domain.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    void 덧셈() {
        Calculator calculator = new Calculator();
        Queue<String> stringQueue = new LinkedList<>();

        stringQueue.add("3");
        stringQueue.add("+");
        stringQueue.add("5");

        int actualResult = calculator.calculate(stringQueue);
        assertThat(actualResult).isEqualTo(6);
    }

    @Test
    void 뺄셈() {
        Calculator calculator = new Calculator();
        Queue<String> stringQueue = new LinkedList<>();

        stringQueue.add("3");
        stringQueue.add("-");
        stringQueue.add("5");

        int actualResult = calculator.calculate(stringQueue);
        assertThat(actualResult).isEqualTo(-2);
    }

    @Test
    void 곱셈() {
        Calculator calculator = new Calculator();
        Queue<String> stringQueue = new LinkedList<>();

        stringQueue.add("3");
        stringQueue.add("*");
        stringQueue.add("5");

        int actualResult = calculator.calculate(stringQueue);
        assertThat(actualResult).isEqualTo(15);
    }

    @Test
    void 나눗셈() {
        Calculator calculator = new Calculator();
        Queue<String> stringQueue = new LinkedList<>();

        stringQueue.add("3");
        stringQueue.add("/");
        stringQueue.add("5");

        int actualResult = calculator.calculate(stringQueue);
        assertThat(actualResult).isEqualTo(0);
    }

    @Test
    void 복합연산() {
        Calculator calculator = new Calculator();
        Queue<String> stringQueue = new LinkedList<>();

        stringQueue.add("2");
        stringQueue.add("+");
        stringQueue.add("3");
        stringQueue.add("*");
        stringQueue.add("4");
        stringQueue.add("/");
        stringQueue.add("2");

        int actualResult = calculator.calculate(stringQueue);
        assertThat(actualResult).isEqualTo(10);
    }


}
