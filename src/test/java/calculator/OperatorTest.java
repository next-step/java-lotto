package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static calculator.Operator.ERR_MSG_OPERATOR;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"%", "^"})
    public void 사칙연산_기호가_아닌_경우(String s) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Operator(s);
                }).withMessageMatching(ERR_MSG_OPERATOR);
    }
}