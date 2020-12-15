package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparator implements Separator {

    public static final String CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)";
    private final Pattern pattern = Pattern.compile(CUSTOM_SEPARATOR_REGEX);

    @Override
    public PositiveNumbers split(InputText inputText) {
        PositiveNumbers positiveNumbers = new PositiveNumbers();
        String text = inputText.getText();
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] values = matcher.group(2).split(customDelimiter);
            positiveNumbers = new PositiveNumbers(getTokens(values));
        }
        return positiveNumbers;
    }

}