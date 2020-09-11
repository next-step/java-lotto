package step1.util;

public class StringUtils {
    public static boolean isNotBlank(String input) {
        if(input == null || input.equals("")) {
            return true;
        }
        return false;
    }

    public static boolean isNumeric(String input) {
        try{
            Double.parseDouble(input);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
