package stringCalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OperationsTest {

    @ParameterizedTest(name = "사칙연산 중 + 일 경우 숫자들을 합한다")
    @CsvSource({"1,2"})
    void test1(int firstNumber, int secondNumber) {
        Operations operations = new Operations();
        assertThat(operations.plus(firstNumber, secondNumber)).isEqualTo(3);
    }

    @ParameterizedTest(name = "사칙연산 중 * 일 경우 숫자들을 곱한다")
    @CsvSource({"1,2"})
    void test2(int firstNumber, int secondNumber) {
        Operations operations = new Operations();
        assertThat(operations.multiplication(firstNumber, secondNumber)).isEqualTo(2);
    }

    @ParameterizedTest(name = "사칙연산 중 - 일 경우 숫자들의 차를 구한다")
    @CsvSource({"1,2"})
    void test3(int firstNumber, int secondNumber) {
        Operations operations = new Operations();
        assertThat(operations.minus(firstNumber, secondNumber)).isEqualTo(-1);
    }

    @ParameterizedTest(name = "사칙연산 중 / 일 경우 몫을 구한다")
    @CsvSource({"4,2"})
    void test4(int firstNumber, int secondNumber) {
        Operations operations = new Operations();
        assertThat(operations.division(firstNumber, secondNumber)).isEqualTo(2);
    }
}