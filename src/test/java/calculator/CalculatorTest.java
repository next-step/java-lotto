package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void assertToIntArray() {
        List<Object> result = new ArrayList<>();
        result.add("1");
        result.add("+");
        result.add("1");

        assertThat(Calculator.toIntArray("1 + 1")).isEqualTo(result);
    }

    @Test
    void assertAddNum() {
        int leftValue = 1;
        int rightValue = 1;

        assertThat(Calculator.addNum(leftValue, rightValue)).isEqualTo(2);
    }

    @Test
    void assertSubtractionNum() {
        int leftValue = 4;
        int rightValue = 2;

        assertThat(Calculator.subtractNum(leftValue, rightValue)).isEqualTo(2);
    }

    @Test
    void assertMultiplyNum() {
        int leftValue = 2;
        int rightValue = 2;

        assertThat(Calculator.multiplyNum(leftValue, rightValue)).isEqualTo(4);
    }

    @Test
    void assertDivideNum() {
        int leftValue = 2;
        int rightValue = 2;

        assertThat(Calculator.divideNum(leftValue, rightValue)).isEqualTo(1);
    }

    @Test
    void assertCalculate() {
        String input = "1 + 1 * 3";

        assertThat(Calculator.calculate(input)).isEqualTo(6);
    }

    @Test
    void assertNullTypeInput() {
        String input = null;

        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Calculator.calculate(input);
        });

        assertThat(thrown.getMessage()).contains("Input String can't be null");
    }

    @Test
    void assertValidOperator() {
        String input = "1 + 2 % 3";

        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Calculator.calculate(input);
        });

        assertThat(thrown.getMessage()).contains("You can't use other operator");
    }
}