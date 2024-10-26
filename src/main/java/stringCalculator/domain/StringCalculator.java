package stringCalculator.domain;

public class StringCalculator {

    public static Integer calculateWithMathExpression(MathExpression mathExpression) {

        int result = mathExpression.numberPoll();

        while (mathExpression.numberHasNext()) {
            result = calculate(mathExpression.operationPoll(), result, mathExpression.numberPoll());
        }

        return result;
    }

    public static Integer calculate(String operation, int firstOperand, int secondOperand) {

        return OperationEnum.findOperationEnum(operation)
                .apply(firstOperand, secondOperand);
    }

}
