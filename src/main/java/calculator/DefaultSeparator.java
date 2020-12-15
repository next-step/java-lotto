package calculator;

import java.util.regex.Pattern;

public class DefaultSeparator implements Separator {

    public static final Pattern SEPARATOR_PATTERN = Pattern.compile("[,:]");

    @Override
    public PositiveNumbers split(InputText inputText) {
        String text = inputText.getText();
        String[] inputTexts = SEPARATOR_PATTERN.split(text);
        return new PositiveNumbers(getPositiveNumberArray(inputTexts));
    }

}