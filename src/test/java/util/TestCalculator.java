package util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestCalculator {

    @ParameterizedTest(name = "Calculator 객체 - 덧셈 테스트")
    @CsvSource({"4, 1", "2, 0"})
    public void test_calculator_plus(int leftNum, int rightNum) {
        assertThat(Calculator.plus(leftNum, rightNum))
            .isEqualTo(leftNum + rightNum);
    }


    @ParameterizedTest(name = "Calculator 객체 - 뺄셈 테스트")
    @CsvSource({"4, 1", "2, 0"})
    public void test_calculator_minus(int leftNum, int rightNum) {
        assertThat(Calculator.minus(leftNum, rightNum))
            .isEqualTo(leftNum - rightNum);
    }


    @ParameterizedTest(name = "Calculator 객체 - 곱셈 테스트")
    @CsvSource({"4, 1", "2, 0"})
    public void test_calculator_multiply(int leftNum, int rightNum) {
        assertThat(Calculator.multiply(leftNum, rightNum))
            .isEqualTo(leftNum * rightNum);
    }


    @ParameterizedTest(name = "Calculator 객체 - 나눗셈 테스트")
    @CsvSource({"4, 1", "2, 1"})
    public void test_calculator_division(int leftNum, int rightNum) {
        assertThat(Calculator.division(leftNum, rightNum))
            .isEqualTo(leftNum / rightNum);
    }
    
}
