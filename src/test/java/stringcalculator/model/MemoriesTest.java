package stringcalculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static stringcalculator.model.Operator.*;

public class MemoriesTest {
    @Test
    void 문자열들을_메모리목록에_저장한다() {
        Memory memory1 = new Memory(convertStringToOperator("*"), new Operand("4"));
        Memory memory2 = new Memory(convertStringToOperator("/"), new Operand("2"));
        Memory memoryFalse11 = new Memory(convertStringToOperator("+"), new Operand("4"));
        Memory memoryFalse12 = new Memory(convertStringToOperator("*"), new Operand("3"));
        Memory memoryFalse21 = new Memory(convertStringToOperator("-"), new Operand("2"));
        Memory memoryFalse22 = new Memory(convertStringToOperator("/"), new Operand("5"));

        Memories actual = new Memories(memory1, memory2);
        Memories expected = new Memories(memory1, memory2);
        Memories falseExpected1 = new Memories(memoryFalse11, memory2);
        Memories falseExpected2 = new Memories(memoryFalse12, memory2);
        Memories falseExpected3 = new Memories(memory1, memoryFalse21);
        Memories falseExpected4 = new Memories(memory1, memoryFalse22);

        assertThat(actual).isEqualTo(expected);
        assertThat(actual).isNotEqualTo(falseExpected1);
        assertThat(actual).isNotEqualTo(falseExpected2);
        assertThat(actual).isNotEqualTo(falseExpected3);
        assertThat(actual).isNotEqualTo(falseExpected4);
    }
}
