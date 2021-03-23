package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperandTest {

    private static int TEST_INT = 1;
    private Operand operand;

    @BeforeEach
    void setUp() {
        //given
        operand = new Operand(TEST_INT);

    }


    @Test
    void createOperand() throws NoSuchFieldException, IllegalAccessException {
        //when, create

        //then-equals(new Instance)로 확인
        assertThat(operand).isEqualTo(new Operand(TEST_INT));

        //then-integer로 변환된 private field 확인
        Field field = operand.getClass().getDeclaredField("operand");
        field.setAccessible(true);
        int operandValue = field.getInt(operand);
        assertThat(operandValue).isEqualTo(TEST_INT);
    }

    @Test
    void validOperand() {
        //given
        Operand negative = new Operand(-1);

        assertThatThrownBy(() -> {
            negative.checkOperand(); //when
        }).isInstanceOf(IllegalArgumentException.class); //then
    }

    @Test
    void operateTest() {
        //given
        Operand newOp = new Operand(TEST_INT + 1);

        //when
        Operand result = operand.operate(newOp, Operator.add());

        //then
        assertThat(result).isEqualTo(new Operand(TEST_INT + TEST_INT + 1));
    }

}
