package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class OperandTest {


    @Test
    void negativeValueCheckTest() {
        String[] str = {"1", "-1", "923"};
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(
            () -> Operand.parseOperand(str));
    }

    @Test
    void normalParsingOperationTest() {
        String str = "1,2,3";

        List<Operand> operandList = new ArrayList<>();
        operandList.add(new Operand(1));
        operandList.add(new Operand(2));
        operandList.add(new Operand(3));

        Operands operands = new Operands(Operand.parseOperand(str.split(",")));

        assertThat(
            operands.getOperandList().get(0).equals(operandList.get(0))).isTrue();
        assertThat(
            operands.getOperandList().get(1).equals(operandList.get(1))).isTrue();
        assertThat(
            operands.getOperandList().get(2).equals(operandList.get(2))).isTrue();

    }
}
