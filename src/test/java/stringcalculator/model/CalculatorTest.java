package stringcalculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static stringcalculator.model.Operator.convertToOperator;

public class CalculatorTest {
    @Test
    void 문자열들을_메모리목록에_저장한다() {
        Memory memory1 = new Memory(convertToOperator("*"), new Operand("4"));
        Memory memory2 = new Memory(convertToOperator("/"), new Operand("2"));
        Memory memoryFalse11 = new Memory(convertToOperator("+"), new Operand("4"));
        Memory memoryFalse12 = new Memory(convertToOperator("*"), new Operand("3"));
        Memory memoryFalse21 = new Memory(convertToOperator("-"), new Operand("2"));
        Memory memoryFalse22 = new Memory(convertToOperator("/"), new Operand("5"));

        Calculator actual = new Calculator(new Operand("2"), memory1, memory2);
        Calculator expected = new Calculator(new Operand("2"), memory1, memory2);
        Calculator falseExpected1 = new Calculator(new Operand("2"), memoryFalse11, memory2);
        Calculator falseExpected2 = new Calculator(new Operand("2"), memoryFalse12, memory2);
        Calculator falseExpected3 = new Calculator(new Operand("2"), memory1, memoryFalse21);
        Calculator falseExpected4 = new Calculator(new Operand("2"), memory1, memoryFalse22);

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

        Memory memory1 = new Memory(convertToOperator(operator1), new Operand(operand1));
        Memory memory2 = new Memory(convertToOperator(operator2), new Operand(operand2));
        Memory memory3 = new Memory(convertToOperator(operator3), new Operand(operand3));

        Calculator calculator = new Calculator(new Operand(operand), memory1, memory2, memory3);
        Result actual = calculator.calculate();
        Result expected = new Result(result);

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
