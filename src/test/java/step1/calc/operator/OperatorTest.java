package step1.calc.operator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class OperatorTest {
    @Test
    void 사칙연산_기호가_아닌경우(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Operator("a");
        }).withMessage("지원하지 않는 연산자입니다: a");

    }

}
