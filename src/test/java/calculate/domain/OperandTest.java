package calculate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperandTest {

    @Test
    public void operand() throws Exception {
        //given
        Operand operand1 = new Operand(2);
        Operand operand2 = new Operand(2);

        //then
        assertThat(operand1.equals(operand2)).isTrue();
    }
}
