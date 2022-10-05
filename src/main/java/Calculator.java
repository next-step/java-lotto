import java.util.Queue;

public class Calculator {
    private Calculator() { }

    public static int calc(String s) {
        Queue<String> formula = FormulaConverter.convert(s);

        int result = Integer.parseInt(formula.poll());
        String operator = null;

        while (!formula.isEmpty()) {
            String op = formula.poll();
            operator = checkOperator(operator, op);
            result = calc(op, operator, result);
        }

        return result;
    }

    private static String checkOperator(String beforeOperator, String operator) {
        if (isNumber(operator)) {
            return beforeOperator;
        }

        return operator;
    }

    private static int calc(String operand, String operator, int result) {
        if (!isNumber(operand)) {
            return result;
        }

        int op2 = Integer.parseInt(operand);
        return Operator.findOperator(operator).calculate(result, op2);
    }

    private static boolean isNumber(String op) {
        try {
            Integer.valueOf(op);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
