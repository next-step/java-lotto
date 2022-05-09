package calculator;

import java.util.List;

public class Calculator {

    private int result;
    private static final int AT_FIRST = 0;
    private List<String> operatorGroup;
    private List<Integer> operandGroup;

    public Calculator(Formula formula) {
        this.operandGroup = formula.findOperand();
        this.operatorGroup = formula.findOperator();
    }

    public int execute() {

        while (!operatorGroup.isEmpty()) {
            calculate();
        }

        return getResult();
    }

    private int getResult() {
        if(operandGroup == null || operandGroup.isEmpty())  return 0;
        return operandGroup.get(AT_FIRST);
    }

    private void calculate() {
        int num1 = operandGroup.remove(AT_FIRST);
        int num2 = operandGroup.remove(AT_FIRST);

        String symbol = operatorGroup.remove(AT_FIRST);

        operandGroup.add(AT_FIRST, Operator.fromString(symbol).calculate(num1, num2));
    }

}
