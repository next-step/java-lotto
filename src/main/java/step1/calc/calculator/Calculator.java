package step1.calc.calculator;


import java.util.List;
import step1.calc.operand.Operand;
import step1.calc.operation.Operation;
import step1.calc.operator.Operator;

public class Calculator {

    public Operand calculate(List<String> expressions) {
        Operand result = new Operand(expressions.get(0));
        for (int i = 1; i < expressions.size(); i += 2) {
            Operation operation = Operator.getOperation(expressions.get(i));
            result = operation.operate(result, new Operand(expressions.get(i + 1)));
        }
        return result;
    }
}
