package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
public class OperandTest {
    @Test
    public void 피연산자_생성() {
        assertThat(new Operand(new Number("1"), new Number("2"))).isEqualTo(new Operand(1, 2));
    }
}
