package calculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class OperandsTest {

    private final Operand zero = new Operand("0");
    private final Operand one = new Operand("1");
    private final Operand two = new Operand("2");

    private final Operands operandsPositive = new Operands(Arrays.asList(zero, one, two));

    @Test
    void sumAll() {
        assertThat(operandsPositive.sumAll()).isEqualTo(3);
    }

}
