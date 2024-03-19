package model;

public class Calculation {

    private static final int FIRST_INDEX = 0;

    public static int calculate(NumberSentence numberSentence) {
        int firstNumber = Integer.parseInt(numberSentence.getExpression(FIRST_INDEX));
        for (int index = 1; index < numberSentence.size(); index+=2) {
            String operator = numberSentence.getExpression(index);
            int secondNumber = Integer.parseInt(numberSentence.getExpression(index + 1));
            firstNumber = calculateByOperator(operator, firstNumber, secondNumber);
        }
        return firstNumber;
    }

    private static int calculateByOperator(String operator, int firstNumber, int secondNumber) {
        if (Operator.PLUS.equals(operator)) {
            return Operator.PLUS.operation(firstNumber, secondNumber);
        }
        else if (Operator.MINUS.equals(operator)) {
            return Operator.MINUS.operation(firstNumber, secondNumber);
        }
        else if (Operator.MULTIPLE.equals(operator)) {
            return Operator.MULTIPLE.operation(firstNumber, secondNumber);
        }
        else if (Operator.DIVIDE.equals(operator)) {
            return Operator.DIVIDE.operation(firstNumber, secondNumber);
        }
        throw new IllegalArgumentException("잘못된 연산자가 들어왔습니다.");
    }

    public static int plus(int firstInput, int secondInput) {
        return firstInput + secondInput;
    }

    public static int minus(int firstInput, int secondInput) {
        return firstInput - secondInput;
    }

    public static int multiple(int firstInput, int secondInput) {
        return firstInput * secondInput;
    }

    public static int divide(int firstInput, int secondInput) {
        return firstInput / secondInput;
    }
}
