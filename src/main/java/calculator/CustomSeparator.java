package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparator implements Separator {

    public static final String CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)";

    @Override
    public Tokens split(InputText inputText) {
        Tokens tokens = new Tokens();
        String text = inputText.getText();
        Matcher m = Pattern.compile(CUSTOM_SEPARATOR_REGEX).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] values = m.group(2).split(customDelimiter);
            tokens = new Tokens(getTokens(values));
        }
        return tokens;
    }

    public static boolean hasCustomSeparator(InputText inputText) {
        String text = inputText.getText();
        Matcher m = Pattern.compile(CUSTOM_SEPARATOR_REGEX).matcher(text);
        return m.matches();
    }

}