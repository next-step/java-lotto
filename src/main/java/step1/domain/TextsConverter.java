package step1.domain;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.regex.Matcher;

public enum TextsConverter {

    CUSTOM(true, TextsConverter::customConverter),
    NORMAL(false,(matcher, text) -> {
        return text.split(",|:");
    });

    public static final int FIRST = 1;
    public static final int SECOND = 2;

    private final boolean isCustom;
    private final BiFunction<Matcher, String, String[]> texts;


    TextsConverter(boolean isCustom, BiFunction<Matcher, String, String[]> texts) {
        this.isCustom = isCustom;
        this.texts = texts;
    }

    public static TextsConverter of(boolean isCustom) {
        return Arrays.stream(TextsConverter.values())
                .filter(textsConverter -> textsConverter.isCustom == isCustom)
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
