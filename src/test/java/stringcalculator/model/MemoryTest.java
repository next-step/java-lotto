package stringcalculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static stringcalculator.model.Operator.convertStringToOperator;

public class MemoryTest {
    @Test
    void 연산자와_피연산자를_저장한다() {
        Memory actual = new Memory(convertStringToOperator("+"), new Operand("3"));
        Memory expected = new Memory(convertStringToOperator("+"), new Operand("3"));
        Memory falseExpected1 = new Memory(convertStringToOperator("/"), new Operand("3"));
        Memory falseExpected2 = new Memory(convertStringToOperator("+"), new Operand("4"));
        Memory falseExpected3 = new Memory(convertStringToOperator("/"), new Operand("4"));

        assertThat(actual).isEqualTo(expected);
        assertThat(actual).isNotEqualTo(falseExpected1);
        assertThat(actual).isNotEqualTo(falseExpected2);
        assertThat(actual).isNotEqualTo(falseExpected3);
    }
}
