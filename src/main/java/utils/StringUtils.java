package utils;

public final class StringUtils {

    private static final String COMMA = ",";
    private static final String COLON = ":";

    private static final int ZERO = 0;

    public static final boolean isNullOrBlank(String sentence) {
        return (isNull(sentence) || isBlank(sentence));
    }

    public static final boolean isNull(String sentence) {
        return sentence == null;
    }

    public static final boolean isBlank(String sentence) {
        return sentence.isEmpty() || sentence.trim().length() == ZERO;
    }

    public static final String[] splitByComma(String sentence) {
        return sentence.split(COMMA);
    }

    public static final String[] splitByCommaAndColon(String sentence) {
        return sentence.split(COMMA + "|" + COLON);
    }
}
