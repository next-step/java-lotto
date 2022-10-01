package step1;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final String DELIMITER = " ";
//    private static final String[] OPERATIONS = {"+", "-", "*", "/"};
    private static final List<String> OPERATIONS = Arrays.asList("+", "-", "*", "/");
    private static final String NUMBER_REG_EXP = "^\\d*$";

    public static int operate(String input) {

        validateEmptyInput(input);

        String[] split = input.split(DELIMITER);

        validateInput(split);

        return calculateNumbers(split);
    }

    private static void validateEmptyInput(String input) {
        if(Objects.isNull(input) || input.trim().isEmpty()) {
            throw new IllegalArgumentException("null이나 빈 값은 입력할 수 없습니다.");
        }
    }

    private static void validateInput(String[] split) {
        for(int i = 0 ; i < split.length ; i++){
            validateInput(i, split[i]);
        }
    }

    private static void validateInput(int index, String input) {
        if(index % 2 == 1) {
            validateOperation(input);
        }
        if(index % 2 == 0){
            validateNumber(input);
        }
    }

    private static void validateOperation(String input) {
        if(!OPERATIONS.contains(input)){
            throw new IllegalArgumentException("올바르지 않은 사칙연산이 포함되어 있습니다.");
        }
    }

    private static void validateNumber(String input) {
        if(!Pattern.matches(NUMBER_REG_EXP, input)){
            throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다.");
        }
    }

    private static int calculateNumbers(String[] split) {
        int arrayIndex = 0;
        int result = Integer.parseInt(split[arrayIndex]);

        while(!isEnd(arrayIndex, split.length)){
            Operator operator = OperatorFactory.getInstance(split[arrayIndex+1]);
            result = operator.operate(result, Integer.parseInt(split[arrayIndex+2]));
            arrayIndex += 2;
        }
        return result;
    }

    private static boolean isEnd(int arrayIndex, int arrayLength) {
        return arrayIndex + 1 >= arrayLength;
    }
}
