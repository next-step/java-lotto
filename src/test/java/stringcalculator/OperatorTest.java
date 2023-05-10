package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    void plus() {
        int result = Operator.PLUS.apply(4, 2);
        assertThat(result).isEqualTo(6);
    }

    void minus() {
        int result = Operator.PLUS.apply(4, 2);
        assertThat(result).isEqualTo(2);
    }

    void multiply() {
        int result = Operator.PLUS.apply(4, 2);
        assertThat(result).isEqualTo(8);
    }

    void divide() {
        int result = Operator.PLUS.apply(4, 2);
        assertThat(result).isEqualTo(2);
    }
}