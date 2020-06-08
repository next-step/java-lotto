package step1;

public class Separator {
    public static final String DEFAULT_SEPARATOR = ",|:";
    public static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";

    public static String[] split(String formula) {
        return formula.split(DEFAULT_SEPARATOR);
    }
}
