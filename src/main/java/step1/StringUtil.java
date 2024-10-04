package step1;

public class StringUtil {

    private final static String BLANK = " ";

    public static String[] splitBlank(String str) {
        return str.split(BLANK);
    }

    public static int toInt(String str) {
        return Integer.parseInt(str);
    }

}
