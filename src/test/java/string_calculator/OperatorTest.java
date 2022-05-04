package string_calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTest {
    @Test
    void computeShouldWork() {
        assertThat(Operator.PLUS.compute.apply(2, 1)).isEqualTo(3);
        assertThat(Operator.MINUS.compute.apply(2, 1)).isEqualTo(1);
        assertThat(Operator.MULTIPLY.compute.apply(2, 1)).isEqualTo(2);
        assertThat(Operator.DIVIDE.compute.apply(2, 1)).isEqualTo(2);
        assertThat(Operator.MODULO.compute.apply(2, 1)).isEqualTo(0);
    }

    @Test
    void createShouldCreateProperOperator() {
        assertThat(Operator.create("+")).isEqualTo(Operator.PLUS);
        assertThat(Operator.create("-")).isEqualTo(Operator.MINUS);
        assertThat(Operator.create("*")).isEqualTo(Operator.MULTIPLY);
        assertThat(Operator.create("/")).isEqualTo(Operator.DIVIDE);
        assertThat(Operator.create("%")).isEqualTo(Operator.MODULO);
        assertThatThrownBy(() -> Operator.create("$")).isInstanceOf(IllegalArgumentException.class);
    }
}
