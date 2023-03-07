package calculator;

import java.util.List;

public class Calculator {

    public static int plus(String str) {
        Seperator seperator = new Seperator(str);
        List<Operand> operands = Operand.parseOperand(seperator.getValue(), seperator.getSeperator());
        return operands.stream().map(Operand::getOperand).mapToInt(i->i).sum();
    }

}
