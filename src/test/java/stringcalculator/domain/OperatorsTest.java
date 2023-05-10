package stringcalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import stringcalculator.constant.Operator;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Test;

class OperatorsTest {

    @Test
    void hasNextFalseTest() {
        assertThat(new Operators().hasNext()).isFalse();
    }

    @Test
    void hasNextTrueTest() {
        assertThat(new Operators(new LinkedList<>(List.of(Operator.ADD))).hasNext()).isTrue();
    }

    @Test
    void removeTest() {
        Operators operators = new Operators(
            new LinkedList<>(List.of(Operator.ADD, Operator.SUBTRACT)));
        assertThat(operators.remove()).isEqualTo(Operator.ADD);
        assertThat(operators.remove()).isEqualTo(Operator.SUBTRACT);
    }

}
