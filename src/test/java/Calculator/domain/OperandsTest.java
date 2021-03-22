package Calculator.domain;

import Calculator.domain.Operand;
import Calculator.domain.Operands;
import Calculator.domain.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OperandsTest {

    private static final int INIT_NUM = 0;
    private static final int BOUND_NUM = 5;
    private Operands operands;
    List<Operand> operandList = new ArrayList<>();


    @BeforeEach
    void setUp() {
        for (int i = INIT_NUM; i < BOUND_NUM; i++) {
            operandList.add(new Operand(i));
        }
        operands = new Operands(operandList);
    }

    @Test
    void createTest() {
        //then
        assertThat(operands).isEqualTo(new Operands(operandList));
    }

    @Test
    void operateAllTest() {
        //given
        int predict = 0;
        for (int i = INIT_NUM; i < BOUND_NUM; i++) {
            predict += i;
        }
        Operand predictOp = new Operand(predict);

        //when
        Operand result = operands.operateAll(Operator.add());

        //then
        assertThat(result).isEqualTo(predictOp);
    }
}
