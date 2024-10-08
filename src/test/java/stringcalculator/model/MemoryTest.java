package stringcalculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest(name = "메모리에서_사칙연산을_계산한다({0} {1} {2} = {3})")
    @CsvSource(value = {
            "2,+,3,5",
            "5,*,4,20",
            "20,/,4,5",
    })
    void 메모리에서_사칙연산을_계산한다(String operand1, String operator, String operand2, String operandResult) {
        Operand firstOperand = new Operand(operand1);
        Memory memory = new Memory(convertStringToOperator(operator), new Operand(operand2));

        Operand actual = memory.calculate(firstOperand);
        Operand expected = new Operand(operandResult);

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
