package stringCalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NumericalExpressionTest {

    @ParameterizedTest(name = "덧셈 연산 테스트")
    @CsvSource(value = {"4,3", "4,5", "5,3"}, delimiter = ',')
    void test1(int leftNumber, int rightNumber) {
        assertThat(NumericalExpression.PLUS.calculate(leftNumber, rightNumber)).isEqualTo(leftNumber + rightNumber);
    }

    @ParameterizedTest(name = "뺄셈 연산 테스트")
    @CsvSource(value = {"3,4", "4,5", "5,3"}, delimiter = ',')
    void test2(int leftNumber, int rightNumber) {
        assertThat(NumericalExpression.SUBTRACT.calculate(leftNumber, rightNumber)).isEqualTo(leftNumber - rightNumber);
    }

    @ParameterizedTest(name = "곱셈 연산 테스트")
    @CsvSource(value = {"3,4", "4,5", "5,3"}, delimiter = ',')
    void test3(int leftNumber, int rightNumber) {
        assertThat(NumericalExpression.MULTIPLY.calculate(leftNumber, rightNumber)).isEqualTo(leftNumber * rightNumber);
    }

    @ParameterizedTest(name = "나눗셈 연산 테스트")
    @CsvSource(value = {"3,4", "4,5", "5,3"}, delimiter = ',')
    void test4(int leftNumber, int rightNumber) {
        assertThat(NumericalExpression.DIVIDE.calculate(leftNumber, rightNumber)).isEqualTo(leftNumber / rightNumber);
    }

    @ParameterizedTest(name = "나눗셈 예외 테스트")
    @CsvSource(value = {"3,0", "4,0", "5,0"}, delimiter = ',')
    void test5(int leftNumber, int rightNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            NumericalExpression.DIVIDE.calculate(leftNumber, rightNumber);
        });
    }

    @Test
    @DisplayName(value = "유효한 연산자 입력 테스트")
    void test6() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            NumericalExpression.valueOfNumericalExpression("%");
        });
    }
}