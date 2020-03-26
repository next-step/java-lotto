package calculate.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OperandsTest {

    @DisplayName("싱성자 테스트")
    @Test
    public void construct() throws Exception {
        //given
        Operands operands1 = new Operands(new Operand(1), new Operand(2), new Operand(3));
        Operands operands2 = new Operands(new Operand(1), new Operand(2), new Operand(3));

        //then
        assertThat(operands1.equals(operands2)).isTrue();
    }

    @DisplayName("Operand List의 사이즈 체크")
    @Test
    public void operandsSize() throws Exception {
        //given
        Operands operands1 = new Operands(new Operand(1));
        Operands operands2 = new Operands(new Operand(1), new Operand(2));
        Operands operands3 = new Operands(new Operand(1), new Operand(2), new Operand(3));

        //then
        assertAll(
                () -> assertEquals(operands1.getOperands().size(), 1),
                () -> assertEquals(operands2.getOperands().size(), 2),
                () -> assertEquals(operands3.getOperands().size(), 3)
        );
    }
}
