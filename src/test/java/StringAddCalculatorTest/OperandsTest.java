package StringAddCalculatorTest;

import stringaddcalculator.Operand;
import stringaddcalculator.Operands;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class OperandsTest {
    @Test
    void Given_OperandList_When_New_Then_InstanceCreated() {
        //given
        List<Operand> operandList = new ArrayList<>();
        operandList.add(new Operand(1));
        operandList.add(new Operand(2));

        //when
        Operands operands = new Operands(operandList);

        //then
        //no compile error
    }

    @Test
    void Given_StringArray_When_New_Then_InstanceCreated() {
        //given
        String[] stringArray = {"1", "2"};
        Operands operands = new Operands(stringArray);

        //then
        //no compile error
    }

    @Test
    void Given_Operands_When_Add_Then_AddedNumber() {
        //given
        Operands operands = new Operands(new String[]{"1", "2"});

        //when
        Operand actual = operands.sum();

        //then
        assertThat(actual).isEqualTo(new Operand(3));
    }
}


