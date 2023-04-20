package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static calculator.Operator.ADD;
import static org.assertj.core.api.Assertions.assertThat;

class OperationTest {

    @CsvSource(value = {
            "1,2,3",
            "2,3,5",
            "0,2,2",
            "-1,5,4",
    })
    @DisplayName("입력값을 기준으로 덧셈 연산 후 결과 값을 반환한다.")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    void test01(int a, int b, int expected) {
        Operation operation = Operation.findType(ADD);
        int actual = operation.calculate(a, b);
        assertThat(actual).isSameAs(expected);
    }

}