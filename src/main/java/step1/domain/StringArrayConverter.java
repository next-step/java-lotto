package step1.domain;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.regex.Matcher;

public enum StringArrayConverter {

    CUSTOM_DELIMETER(true, StringArrayConverter::customConverter),
    NORMAL_DELIMETER(false,(matcher, text) -> {
        return text.split(",|:");
    });

    public static final int FIRST = 1;
    public static final int SECOND = 2;

    private final boolean isCustomDelimeter;
    private final BiFunction<Matcher, String, String[]> texts;


    StringArrayConverter(boolean isCustomDelimeter, BiFunction<Matcher, String, String[]> texts) {
        this.isCustomDelimeter = isCustomDelimeter;
        this.texts = texts;
    }

    public static StringArrayConverter of(boolean isCustomDelimeter) {
        return Arrays.stream(StringArrayConverter.values())
                .filter(textToTextsConverter -> textToTextsConverter.isCustomDelimeter == isCustomDelimeter)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 입력값입니다."));
    }

    private static String[] customConverter(Matcher matcher, String text) {
        String customDelimiter = matcher.group(FIRST);
        return matcher.group(SECOND).split(customDelimiter);
    }

    public String[] getTexts (Matcher matcher, String text) {
        return texts.apply(matcher, text);
    }
}
