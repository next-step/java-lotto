package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntBinaryOperator;

public class TwoOperandCalculator {
    private static final Map<String, IntBinaryOperator> operaterMap = new HashMap<>();

    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULTIPLY = "*";
    public static final String DEVIDE = "/";

    private static TwoOperandCalculator twoOperandCalculator;
    Operator operator;

    private TwoOperandCalculator() {

    }

    public static TwoOperandCalculator getOperatorSelection() {
        if (twoOperandCalculator == null) {
            twoOperandCalculator = new TwoOperandCalculator();
        }
        return twoOperandCalculator;
    }

    public IntBinaryOperator findOperator(String operatorToFind) {
        return operator.getOperatorMethod(operatorToFind);
    }

    public int calculateTwoOperands(int firstOperand, int secondOperand, String operator) {
        return findOperator(operator).applyAsInt(firstOperand, secondOperand);
    }

}
