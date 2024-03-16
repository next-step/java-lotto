package stringCalculator;

import java.util.Arrays;

public class Utils {
    private static final String ADDITION = "+";
    private static final String SUBSTRACTION = "-";
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";

    public static void checkBlank(String input){
        if(input.isBlank()){
            throw new IllegalArgumentException("입력값을 입력해주세요");
        }
    }

    public static String[] splitString(String input){
        return input.split(" ");
    }

    public static void checkNumOrOperators(String[] input){
        for (int i = 0; i<input.length ; i++){
            checkNumOrOperator(input[i]);
        }
    }

    private static void checkNumOrOperator(String value){
        if(!isOperator(value)){
            checkNum(value);
        }
    }

    private static boolean isOperator(String value){
        String[] Operator = {ADDITION, SUBSTRACTION, MULTIPLICATION, DIVISION};
        return Arrays.stream(Operator).anyMatch(value::equals);
    }

    private static void checkNum(String value){
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 입력");
        }
    }

    public static void checkNumAndOperatorAlternately(String[] value){
        for (int i = 0; i< value.length - 1; i++) {
            checkSameForm(value[i], value[i + 1]);
        }
    }

    private static void checkSameForm(String value1, String value2){
        if(isOperator(value1) == isOperator(value2)){
            throw new IllegalArgumentException("숫자나 기호의 연속 입력");
        }
    }

    public static void checkLastElement(String[] value){
        if(isOperator(value[value.length - 1])){
            throw new IllegalArgumentException("마지막 입력은 숫자");
        }
    }

}
