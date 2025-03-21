package step1.calc.operator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import step1.calc.operand.Operand;

public class OperatorTest {
    @Test
    void 사칙연산_기호가_아닌경우(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operand aOperand = new Operand("1");
            Operand bOperand = new Operand("2");
            new Operator("a", aOperand, bOperand);
        }).withMessage("지원하지 않는 연산자입니다.");

    }

}
