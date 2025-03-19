package calculator.expression;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MultiplyOperatorTest {
    @ParameterizedTest
    @CsvSource(value = {"2:1:2", "2:4:8", "5:2:10", "21:9:189"}, delimiter = ':')
    void 연산_확인(int left, int right, int result){
        MultiplyOperator operator = new MultiplyOperator();
        assertThat(operator.operate(left, right)).isEqualTo(result);
    }

    @Test
    void 값_꺼내기_불가() {
        MultiplyOperator operator = new MultiplyOperator();
        assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> {
                    operator.getValue();
                }).withMessageMatching("not supported in Operator");
    }
}
