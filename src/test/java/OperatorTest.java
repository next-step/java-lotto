import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class OperatorTest {
    @Test
    void plus() {
        final Operator operator = new PlusOperator();
        assertThat(operator.calculate(1, 2)).isEqualTo(3);
    }

    @Test
    void minus() {
        final Operator operator = new MinusOperator();
        assertThat(operator.calculate(2, 1)).isEqualTo(1);
    }

    @Test
    void multiplication() {
        final Operator operator = new MultiplicationOperator();
        assertThat(operator.calculate(2, 3)).isEqualTo(6);
    }

    @Test
    void division() {
        final Operator operator = new DivisionOperator();
        assertThat(operator.calculate(6, 3)).isEqualTo(2);
    }
}
