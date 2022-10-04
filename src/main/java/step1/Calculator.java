package step1;

public class Calculator {

    public static final String NULL_EXCEPTION = "입력값은 null이거나 공백일 수 없습니다.";
    public static final String NUMBER_EXCEPTION = "잘못된 숫자입니다.";
    public static final String SPLIT_TEXT = " ";

    public static int calculator(String input) {

        String[] splitInput = validate(input).split(SPLIT_TEXT);
        int result = 0;

        for (int i = 1; i < splitInput.length - 1; i += 2) {
            int firstNum = getFirstNum(splitInput, result, i);
            int secondNum = checkInt(splitInput[i + 1]);
            result = caculateInput(firstNum, secondNum, splitInput[i]);
        }

        return result;
    }

    private static int getFirstNum(String[] splitInput, int result, int i) {
        int firstNum = result;
        if (i == 1) {
            firstNum = checkInt(splitInput[i - 1]);
        }
        return firstNum;
    }

    private static String validate(String input) {
        if(input == null || input.isBlank()){
            throw new IllegalArgumentException(NULL_EXCEPTION);
        }
        return input;
    }

    private static int caculateInput(int firstNum, int secondNum, String operator) {
        return OperatorType.getType(operator).exe(firstNum,secondNum);
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

}
