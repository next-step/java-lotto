package Calculator;

public class StringUtils {

    public static boolean checkEmpty(String input) {
        if (input == null || input.isEmpty() || input.equals("")) {
            return true;
        }
        return false;
    }

}
