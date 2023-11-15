import java.util.List;

public class Calculator {
    private static final String SUM_OPERATOR = "+";
    private static final String SUBTRACTION_OPERATOR = "-";
    private static final String MULTIPLICATION_OPERATOR = "*";
    private static final String DIVISION_OPERATOR = "/";

    public static int stringCalculate(String inputString) {
        SplitString splitString = new SplitString(inputString);

        return splitString.stringOperate();
    }

    public static int operate(String operator, int result, int operand) {
        if(operator.equals(SUM_OPERATOR)) return sum(result, operand);
        if(operator.equals(SUBTRACTION_OPERATOR)) return subtraction(result, operand);
        if(operator.equals(MULTIPLICATION_OPERATOR)) return multiplication(result, operand);
        if (operator.equals(DIVISION_OPERATOR)) return division(result, operand);

        return 0;
    }

    private static int sum(int number1, int number2){
        return number1 + number2;
    }

    private static int subtraction(int number1, int number2){
        return number1 - number2;
    }

    private static int multiplication(int number1, int number2) {
        return number1 * number2;
    }

    private static int division(int number1, int number2) {
        return number1 / number2;
    }
}
