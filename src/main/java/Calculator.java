import domain.Operand;
import domain.Operands;
import domain.Operators;

public class Calculator {

    public static int calculate(Operators operators, Operands operands) {
        Operand result = operators.calculate(operands);
        return result.getValue();
    }
}
