package calculator.expression;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AddOperatorTest {

    @ParameterizedTest
    @CsvSource(value = {"2:1:3", "2:4:6", "5:2:7", "21:9:30"}, delimiter = ':')
    void 연산_확인(int left, int right, int result) {
        AddOperator operator = new AddOperator();
        assertThat(operator.operate(left, right)).isEqualTo(result);
    }
}
