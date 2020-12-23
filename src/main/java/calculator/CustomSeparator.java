package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparator implements Separator {

    private static final Pattern SEPARATOR_PATTERN = Pattern.compile("//(.)\n(.*)");

    @Override
    public PositiveNumbers split(InputText inputText) {
        PositiveNumbers positiveNumbers = new PositiveNumbers();
        String text = inputText.getText();
        Matcher matcher = SEPARATOR_PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] values = matcher.group(2).split(customDelimiter);
            positiveNumbers = new PositiveNumbers(getPositiveNumberArray(values));
        }
        return positiveNumbers;
    }

    @Override
    public Pattern getSeparatorPattern() {
        return SEPARATOR_PATTERN;
    }

}