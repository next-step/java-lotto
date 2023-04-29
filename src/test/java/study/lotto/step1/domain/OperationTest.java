package study.lotto.step1.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OperationTest {
    @Test
    void calculation() {
        // given
        Operation operation = new Operation(new Operand("3"), new Operand("4"), Operator.MULTIPLY);

        // when
        OperationResult operated = operation.calculate();

        // then
        Assertions.assertThat(operated).isEqualTo(new OperationResult("12"));
    }
}