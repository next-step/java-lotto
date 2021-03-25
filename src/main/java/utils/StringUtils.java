package utils;

public final class StringUtils {

    public static final boolean isNullOrBlank(String sentence) {
        return (isNull(sentence) || isBlank(sentence));
    }

    public static final boolean isNull(String sentence) {
        return sentence == null;
    }

    public static final boolean isBlank(String sentence) {
        return sentence.trim().isEmpty();
    }

}
