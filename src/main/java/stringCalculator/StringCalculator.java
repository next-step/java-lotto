package stringCalculator;

public class StringCalculator {

    public static Integer calculate(MathExpression mathExpression) {

        int result = mathExpression.numberPoll();

        while (mathExpression.numberHasNext()) {
            result = add(mathExpression.operationPoll(), mathExpression.numberPoll(), result);
        }

        return result;
    }

    public static Integer add(String operation, Integer number, Integer result) {
        if (operation.equals("+"))
            return result + number;
        return result;
    }
}
