import java.util.List;

public class Calculator {
    private static final String SUM_DELIMITER = "+";
    private static final String SUBTRACTION_DELIMITER = "-";
    private static final String MULTIPLICATION_DELIMITER = "*";
    private static final String DIVISION_DELIMITER = "/";

    public static int stringCalculate(String inputString) {
        List<Integer> numberList = SplitString.splitNumber(inputString);
        List<String> operatorList = SplitString.splitOperator(inputString);

        int result = numberList.get(0);

        for(int i=0; i<operatorList.size(); i++){
            result = operate(operatorList.get(i), result, numberList.get(i +1));
        }

        return result;
    }

    public static int operate(String operator, int result, int operand) {
        if(operator.equals(SUM_DELIMITER)) return sum(result, operand);
        if(operator.equals(SUBTRACTION_DELIMITER)) return subtraction(result, operand);
        if(operator.equals(MULTIPLICATION_DELIMITER)) return multiplication(result, operand);
        if (operator.equals(DIVISION_DELIMITER)) return division(result, operand);

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
