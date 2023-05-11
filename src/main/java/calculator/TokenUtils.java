package calculator;

import java.util.List;

public class TokenUtils {

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isOperator(String input) {
        List<String> operators = List.of("+", "-", "*", "/");
        return operators.contains(input);
    }
}
