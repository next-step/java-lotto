package calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class OperandTest {
    @Test
    void parsingTest1() {

        String origin = "1;2;3";
        String seperator = ";";

        List<Operand> operands = Operand.parseOperand(origin, seperator);

        for (Operand o : operands) {
            System.out.println(o.getOperand());
        }

    }

    @Test
    void parsingTest2() {

        String origin = "//[\\n1[2[3";
        String seperator = "[";

        List<Operand> operands = Operand.parseOperand(origin, seperator);

        for (Operand o : operands) {
            System.out.println(o.getOperand());
        }

    }

    @Test
    void parsingTest3() {

        String origin = "//*\\n1*2*3";
        String seperator = "\\*";

        List<Operand> operands = Operand.parseOperand(origin, seperator);

        for (Operand o : operands) {
            System.out.println(o.getOperand());
        }

    }
}
