import java.util.Queue;

public class Calculator {

    static int result;

    public static int calc(String s) {
        Queue<String> formula = FormulaConverter.convert(s);

        result = Integer.parseInt(formula.poll());
        String operator = null;

        while (!formula.isEmpty()) {
            String op = formula.poll();
            operator = checkOperator(operator, op);
            calc(op, operator);
        }

        return result;
    }

    private static String checkOperator(String beforeOperator, String operator) {
        if (isNumber(operator)) {
            return beforeOperator;
        }

        return operator;
    }

    private static void calc(String operand, String operator) {
        if (!isNumber(operand)) {
            return;
        }

        int op2 = Integer.parseInt(operand);
        result = Operator.findOperator(operator).calculate(result, op2);
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
