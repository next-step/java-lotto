package calculator;

public class Splitter {
    private static final String DEFAULT_REGEX = ",|:";

    public static String[] split(String str){

        return str.split(DEFAULT_REGEX);
    }
}
