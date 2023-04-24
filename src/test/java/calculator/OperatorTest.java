package calculator;

import calculator.domain.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
    @DisplayName("덧셈 연산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3", "1,3,4"})
    void add(int x, int y, int expected) {
        Operator operator = Operator.from("+");
        int result = operator.operate(x, y);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("뺄셈 연산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3,2,1", "4,5,-1"})
    void sub(int x, int y, int expected) {
        Operator operator = Operator.from("-");
        int result = operator.operate(x, y);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("곱셈 연산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2,3,6", "1,2,2"})
    void multi(int x, int y, int expected) {
        Operator operator = Operator.from("*");
        int result = operator.operate(x, y);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("나눗셈 연산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"4,2,2", "6,1,6"})
    void divide(int x, int y, int expected) {
        Operator operator = Operator.from("/");
        int result = operator.operate(x, y);
        assertThat(result).isEqualTo(expected);
    }
}
