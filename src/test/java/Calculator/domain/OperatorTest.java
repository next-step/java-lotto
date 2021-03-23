package Calculator.domain;

import Calculator.domain.Operator;
import org.junit.jupiter.api.Test;

import java.util.function.BinaryOperator;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
    @Test
    void addTest() {
        BinaryOperator<Integer> addOp = Operator.add();
        assertThat(addOp.apply(1, 2)).isEqualTo(3);
    }
}
