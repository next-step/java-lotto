package stringCalculator;

public class StringCalculator {

    public static Integer calculate(MathExpression mathExpression) {

        int result = mathExpression.numberPoll();

        while (mathExpression.numberHasNext()) {
            result = add(mathExpression.operationPoll(), mathExpression.numberPoll(), result);
        }

        return result;
    }

    public static Integer add(String operation, Integer result, Integer number) {
        if (operation.equals("+"))
            return result + number;
        return result;
    }

    public static Integer subtract(String operation, Integer result, Integer number) {
        if (operation.equals("-"))
            return result - number;
        return result;
    }

    public static Integer multiply(String operation, Integer result, Integer number) {
        if (operation.equals("*"))
            return result * number;
        return result;
    }

    public static Integer divide(String operation, Integer result, Integer number) {
        if (operation.equals("/"))
            return result / number;
        return result;
    }
}
