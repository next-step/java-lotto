package Util;

public class CheckInput {
    private static final String[] OPERATORS = {"+", "-", "*", "/"};
    public static boolean isOperator(String str) {
        boolean isOperator = false;
        for (String operator: OPERATORS) {
            isOperator = isOperator || operator.equals(str);
        }

        if (isOperator) {
            return true;
        }

        throw new IllegalArgumentException("연산자가 아닙니다.");
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
