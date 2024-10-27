package stringCalculator.domain;

public class StringCalculator {

    public static Integer calculateWithMathExpression(MathExpression mathExpression) {

        int result = mathExpression.numberPoll();

        while (mathExpression.numberHasNext()) {
            result = calculate(mathExpression.operationPoll(), result, mathExpression.numberPoll());
        }

        return result;
    }

    public static Integer calculate(OperationEnum operation, int firstOperand, int secondOperand) {

        return operation.apply(firstOperand, secondOperand);
    }

    public static Integer add(Integer firstOperand, Integer secondOperand) {
        return OperationEnum.findOperationEnum("+").apply(firstOperand, secondOperand);
    }

    public static Integer subtract(Integer firstOperand, Integer secondOperand) {
        return OperationEnum.findOperationEnum("-").apply(firstOperand, secondOperand);
    }

    public static Integer multiply(Integer firstOperand, Integer secondOperand) {
        return OperationEnum.findOperationEnum("*").apply(firstOperand, secondOperand);
    }

    public static Integer divide(Integer firstOperand, Integer secondOperand) {
        return OperationEnum.findOperationEnum("/").apply(firstOperand, secondOperand);
    }
}
