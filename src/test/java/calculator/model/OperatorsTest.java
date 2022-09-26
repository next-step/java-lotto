package calculator.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorsTest {

    @Test
    void shouldNotHaveMultipleOperator(){
        Operators operators = new Operators();
        operators.add(Operator.MINUS);
        assertThrows(IllegalArgumentException.class,()->operators.add(Operator.PLUS));
    }

}
