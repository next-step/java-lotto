package calculator.expression;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SubtractOperatorTest {

    @ParameterizedTest
    @CsvSource(value = {"2:1:1", "2:4:-2", "5:2:3", "21:9:12"}, delimiter = ':')
    void 연산_확인(int left, int right, int result) {
        SubtractOperator operator = new SubtractOperator();
        assertThat(operator.operate(left, right)).isEqualTo(result);
    }
}
