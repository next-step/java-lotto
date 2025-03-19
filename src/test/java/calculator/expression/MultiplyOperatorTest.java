package calculator.expression;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MultiplyOperatorTest {
    @ParameterizedTest
    @CsvSource(value = {"2:1:2", "2:4:8", "5:2:10", "21:9:189"}, delimiter = ':')
    void 연산_확인(int left, int right, int result){
        MultiplyOperator operator = new MultiplyOperator();
        assertThat(operator.operate(left, right)).isEqualTo(result);
    }
}
