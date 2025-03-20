package calculator.expression;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

public class OperatorTest {

    @Test
    void 값_꺼내기_불가() {
        Operator operator = new Operator() {
            @Override
            public int operate(int left, int right) {
                return 0;
            }
        };

        assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> {
                    operator.getValue();
                }).withMessageMatching("not supported in Operator");
    }
}
