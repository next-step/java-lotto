package model;

public class Calculation {
    private static final String PLUS_OPERATOR = "+";
    private static final String MINUS_OPERATOR = "-";
    private static final String MULTIPLE_OPERATOR = "*";
    private static final String DIVIDE_OPERATOR = "/";

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
        if (operator.equals(PLUS_OPERATOR)) {
            return plus(firstNumber, secondNumber);
        }
        else if (operator.equals(MINUS_OPERATOR)) {
            return minus(firstNumber, secondNumber);
        }
        else if (operator.equals(MULTIPLE_OPERATOR)) {
            return multiple(firstNumber, secondNumber);
        }
        else if (operator.equals(DIVIDE_OPERATOR)) {
            return divide(firstNumber, secondNumber);
        }
        throw new IllegalArgumentException("잘 못된 연산자가 들어왔습니다.");
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
