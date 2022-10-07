package calculator.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class OperationTest {
    @ParameterizedTest
    @CsvSource(value = {"2,3,5", "1,1,2"})
    void 덧셈_계산_테스트(int num1, int num2, int expected) {
        assertThat(new PlusOperationImpl().calculate(num1, num2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2,3,-1", "1,1,0"})
    void 뺄셈_계산_테스트(int num1, int num2, int expected) {
        assertThat(new MinusOperationImpl().calculate(num1, num2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2,3,6", "1,1,1"})
    void 곱셈_계산_테스트(int num1, int num2, int expected) {
        assertThat(new MultipleOperationImpl().calculate(num1, num2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"6,3,2", "1,1,1"})
    void 나눗셈_계산_테스트(int num1, int num2, int expected) {
        assertThat(new DivisionOperationImpl().calculate(num1, num2)).isEqualTo(expected);
    }
}
