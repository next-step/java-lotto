package Calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperandTest {

    private static String TEST_STR = "1";
    private static int TEST_INT = 1;
    private Operand operand;

    @BeforeEach
    void setUp() {
        //given
        operand = new Operand(TEST_STR);

    }


    @Test
    void createOperand() throws NoSuchFieldException, IllegalAccessException {
        //when, create

        //then-equals로 확인
        assertThat(operand).isEqualTo(new Operand(TEST_STR));

        //then-integer로 변환된 private field 확인
        Field field = operand.getClass().getDeclaredField("operand");
        field.setAccessible(true);
        int operandValue = field.getInt(operand);
        assertThat(operandValue).isEqualTo(TEST_INT);
    }

    @Test
    void validOperand() {
        //given
        Operand negative = new Operand("-1");

        assertThatThrownBy(() -> {
            negative.checkOperand(); //when
        }).isInstanceOf(IllegalArgumentException.class); //then
    }

}
