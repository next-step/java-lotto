package lotto.util;

public class NumberUtils {

    public static Integer returnInteger (String string) {
        try {
            return Integer.parseInt(string);
        } catch(NumberFormatException e) {
            return null;
        }
    }

}
