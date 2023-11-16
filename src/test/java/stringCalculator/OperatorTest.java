package stringCalculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import stringCalculator.domain.Operator;

class OperatorTest {

    @Test
    @DisplayName("operator를 정확하게 찾는지 확인한다.")
    void test1() {
        String input = "+";
        Operator expectingResult = Operator.ADD;

        assertThat(Operator.find(input)).isEqualTo(expectingResult);
    }

    @Test
    @DisplayName("잘못된 operator가 입력될 시 exception을 반환한다.")
    void test2() {
        String input = "?";

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Operator.find(input))
            .withMessageMatching("Need correct arithmetic operator");
    }

    @ParameterizedTest
    @CsvSource(value = { "+:10", "-:4", "*:21", "/:2" }, delimiter = ':')
    @DisplayName("계산이 정확하게 이루어지는지 확인한다.")
    void test3(String stringOperator, int expectingResult) {
        int num1 = 7;
        int num2 = 3;

        assertThat(Operator.find(stringOperator).calculate(num1, num2))
            .isEqualTo(expectingResult);
    }

    @Test
    @DisplayName("나누는 수가 0이면면 Exception를 반환하는지 확인한다.")
    void test4() {
        int num1 = 7;
        int num2 = 0;
        String stringOperator = "/";

        assertThatExceptionOfType(ArithmeticException.class)
            .isThrownBy(() -> Operator.find(stringOperator).calculate(num1, num2))
            .withMessageMatching("You cannot divide a number with 0");
    }

}
