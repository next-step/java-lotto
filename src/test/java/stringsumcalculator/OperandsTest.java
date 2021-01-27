package stringsumcalculator;

import org.junit.jupiter.api.Test;
import stringsumcalculator.model.Operands;
import stringsumcalculator.model.Separators;
import org.junit.jupiter.api.DisplayName;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperandsTest {

    @Test
    @DisplayName("피연산자가 제대로 분리되는가")
    public void createOperands(){
        String string = "//;\\n1;2;3;4";

        Separators separators = new Separators(string);
        Operands operands = new Operands(separators.getFormula() , separators);

        assertEquals(operands.getOperand(0),1);
        assertEquals(operands.getOperand(1),2);
        assertEquals(operands.getOperand(2),3);
        assertEquals(operands.getOperand(3),4);

    }

}
