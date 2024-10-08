package stringcalculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static stringcalculator.model.Operator.convertStringToOperator;

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

    @ParameterizedTest(name = "메모리목록에서_사칙연산들을_계산한다({0} {1} {2} {3} {4} {5} {6} = {7})")
    @CsvSource(value = {
            "2,+,3,*,4,/,2,10",
            "8,+,9,*,9,/,36,4",
    })
    void 메모리목록에서_사칙연산들을_계산한다(String operand,
                             String operator1, String operand1,
                             String operator2, String operand2,
                             String operator3, String operand3,
                             int result) {

        Operand initOperand = new Operand(operand);
        Memory memory1 = new Memory(convertStringToOperator(operator1), new Operand(operand1));
        Memory memory2 = new Memory(convertStringToOperator(operator2), new Operand(operand2));
        Memory memory3 = new Memory(convertStringToOperator(operator3), new Operand(operand3));

        Memories memories = new Memories(memory1, memory2, memory3);
        Result actual = memories.allCalculate(initOperand);
        Result expected = new Result(result);

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
