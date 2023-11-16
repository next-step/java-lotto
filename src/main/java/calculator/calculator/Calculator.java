package calculator.calculator;

public class Calculator {
    private static final String SEPARATOR = " ";
    private static final String CHECK_OPERATION = "+-*/";

    public static int cal(String inputStr) {
        if (isBlank(inputStr)) {
            throw new IllegalArgumentException("빈 값 입력은 오류입니다.");
        }

        String[] inputStrArr = split(inputStr);
        int result = parseInt(inputStrArr[0]);

        if (inputStrArr.length == 1) {
            return result;
        }

        for (int i = 2; i < inputStrArr.length; i += 2) {
            result = calculate(result, parseInt(inputStrArr[i]), inputStrArr[i - 1]);
        }

        return result;

    }

    private static int calculate(int result, int number, String operation) {
        isContainsOperation(operation);
        if(operation.equals("+")) {
            result =  Math.addExact(result, number);
        }

        if(operation.equals("-")) {
            result =  Math.subtractExact(result, number);
        }

        if(operation.equals("*")) {
            result =  Math.multiplyExact(result, number);
        }

        if(operation.equals("/")) {
            result =  Math.floorDiv(result, number);
        }
        return result;
    }

    private static int parseInt(String strNumber) {
        return Integer.parseInt(strNumber);
    }

    private static boolean isBlank(String inputStr) {
        return inputStr == null || inputStr.isBlank();
    }

    private static void isContainsOperation(String operation) {
        if(!CHECK_OPERATION.contains(operation)){
            throw new IllegalArgumentException("연산자가 잘못 입력 되었습니다.");
        }
    }

    private static String[] split(String inputStr) {
        return inputStr.split(SEPARATOR);
    }
}
