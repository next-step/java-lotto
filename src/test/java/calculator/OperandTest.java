package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class OperandTest {

    @Test
    void Operand_피연산자_생성() {
        Operand operand = new Operand("3");
        assertThat(operand).isEqualTo(new Operand(3));
    }

    @Test
    void Operand_피연산자_숫자가_아닌_경우() {
        assertThatThrownBy(() -> new Operand("+")).isInstanceOf(IllegalArgumentException.class);
    }
}
