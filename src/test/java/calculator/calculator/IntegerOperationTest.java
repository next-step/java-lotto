package calculator.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class IntegerOperationTest {
    @Test
    void 사칙연산자가_아닌_문자열에_대해_valueOfOperator_호출시_예외를_던진다() {
        String invalidOperator = "^";

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> IntegerOperation.valueOfOperator(invalidOperator));
    }
}
