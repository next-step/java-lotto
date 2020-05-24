package calculator.util;

public class CommonUtil {
    public static void validateNullEmpty(String text, String errMessage) throws IllegalArgumentException{
        if(text == null || text.isEmpty()) {
            throw new IllegalArgumentException(errMessage);
        }
    }
}
