package calculator;

import java.util.Objects;

public class InputValidator {
    public static boolean validationInputString(String input){
        if(Objects.isNull(input) || "".equals(input)){
            return false;
        }
        return true;
    }

    public static int validationNumbersNegative(int number){
        if(number < 0){
            throw new RuntimeException("음수 입력");
        }
        return number;
    }
}
