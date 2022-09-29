package step1;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Calculator {

    public static final String NULL_EXCEPTION = "입력값은 null이거나 공백일 수 없습니다.";
    public static final String NUMBER_EXCEPTION = "잘못된 숫자입니다.";
    public static final String OPEATOR_EXCEPTION = "잘못된 사칙연산 기호 입니다.";
    public static final String SPLIT_TEXT = " ";

    public static int calculator(String input) {

        String[] splitInput = validate(input).split(SPLIT_TEXT);
        int result = 0;

        for (int i = 1; i < splitInput.length - 1; i += 2) {
            int firstNum = result;
            if (i == 1) {
                firstNum = checkInt(splitInput[i - 1]);
            }
            int secondNum = checkInt(splitInput[i + 1]);
            String operator = checkOperation(splitInput[i]);
            result = caculateResult(firstNum, secondNum, operator);
        }

        return result;
    }

    private static String validate(String input) {
        if(input == null || input.isBlank()){
            throw new IllegalArgumentException(NULL_EXCEPTION);
        }
        return input;
    }

    private static int caculateResult(int firstNum, int secondNum, String operator) {
        int result = 0;
        if (operator.equals(OperatorType.PLUS.getValue())) {
            result = Operator.plus(firstNum, secondNum);
        }
        if (operator.equals(OperatorType.MINUS.getValue())) {
            result = Operator.minus(firstNum, secondNum);
        }
        if (operator.equals(OperatorType.TIMES.getValue())) {
            result = Operator.times(firstNum, secondNum);
        }
        if (operator.equals(OperatorType.DIVISION.getValue())) {
            result = Operator.division(firstNum, secondNum);
        }

        return result;
    }

    private static int checkInt(String input){
        int result;
        try{
            result = Integer.parseInt(input);
        }catch (Exception e){
            throw new IllegalArgumentException(NUMBER_EXCEPTION);
        }
        return result;
    }

    private static String checkOperation(String input) {
        if (!Arrays.stream(OperatorType.values()).map(it->it.getValue()).collect(Collectors.toList()).contains(input)) {
            throw new IllegalArgumentException(OPEATOR_EXCEPTION);
        }
        return input;
    }
}
