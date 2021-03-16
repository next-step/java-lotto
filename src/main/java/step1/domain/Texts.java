package step1.domain;

import step1.utils.TextMatcher;

import java.util.regex.Matcher;

public class Texts {
    public static final String RESET = "0";

    private final String[] texts;

    public Texts(String text) {
        text = isNullAndEmptyValidation(text);
        this.texts = textToTexts(text);
    }

    private String isNullAndEmptyValidation(String text) {
        if (text == null || text.isEmpty()) {
            text = RESET;
        }
        return text;
    }

    private String[] textToTexts(String text) {
        Matcher matcher = TextMatcher.getMatcher(text);
        return TextsConverter.of(matcher.find()).getTexts(matcher, text);
    }

    public String[] getTexts() {
        return texts;
    }

}
