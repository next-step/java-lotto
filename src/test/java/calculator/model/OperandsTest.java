package calculator.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class OperandsTest {

    @Test
    void shouldNotHaveOperandsMoreThenThree(){
        Operands operands = new Operands();
        operands.add(new Operand("1"));
        operands.add(new Operand("2"));
        assertThrows(IllegalArgumentException.class,()->operands.add(new Operand("-1")));
    }

}
