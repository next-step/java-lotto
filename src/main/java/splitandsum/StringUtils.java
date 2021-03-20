package splitandsum;


public class StringUtils {

    public static String[] split(String number, String numberPattern) {
        String[] numbers = number.split(numberPattern);
        return numbers;
    }
}
