package step1.calc.operation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import step1.calc.operand.Operand;
import step1.calc.operation.addition.Addition;
import step1.calc.operation.division.Division;
import step1.calc.operation.multiplication.Multiplication;
import step1.calc.operation.subtraction.Subtraction;

public class OperationTest {

    @Test
    void 더하기_테스트() {
        Operand aOperand = new Operand("1");
        Operand bOperand = new Operand("2");

        Operation operation = new Addition(aOperand, bOperand);
        assertThat(operation.operate().operand()).isEqualTo(3);
    }

    @Test
    void 빼기_테스트() {
        Operand aOperand = new Operand("3");
        Operand bOperand = new Operand("2");

        Operation operation = new Subtraction(aOperand, bOperand);
        assertThat(operation.operate().operand()).isEqualTo(1);
    }

    @Test
    void 곱하기_테스트() {
        Operand aOperand = new Operand("3");
        Operand bOperand = new Operand("2");

        Operation operation = new Multiplication(aOperand, bOperand);
        assertThat(operation.operate().operand()).isEqualTo(6);
    }

    @Test
    void 나누기_테스트() {
        Operand aOperand = new Operand("6");
        Operand bOperand = new Operand("2");

        Operation operation = new Division(aOperand, bOperand);
        assertThat(operation.operate().operand()).isEqualTo(3);
    }

    @Test
    void 나머지가_있는_나누기_테스트_정수만표현() {
        Operand aOperand = new Operand("5");
        Operand bOperand = new Operand("2");

        Operation operation = new Division(aOperand, bOperand);
        assertThat(operation.operate().operand()).isEqualTo(2);
    }
}
