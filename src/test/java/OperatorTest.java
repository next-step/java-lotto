import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OperatorTest {

    @Test
    void add() {
        int result = Operator.ADD.formula.apply(3, 2);
        assertThat(result).isEqualTo(5);
    }

    @Test
    void subtract() {
        int result = Operator.SUBTRACT.formula.apply(3, 2);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void multiply() {
        int result = Operator.MULTIPLY.formula.apply(3, 2);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void divide() {
        int result = Operator.DIVIDE.formula.apply(6, 3);
        assertThat(result).isEqualTo(2);
    }
}
