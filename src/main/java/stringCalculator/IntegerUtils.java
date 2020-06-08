package stringCalculator;

public class IntegerUtils {
    public static int parsing(String calcStr) {
        try {
            int num = Integer.parseInt(calcStr);
            return num;
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }
}
