package calculator;

public class DefaultSeparator implements Separator {

    public static final String SPLIT_REGEX = "[,:]";

    @Override
    public Tokens split(InputText inputText) {
        String text = inputText.getText();
        String[] inputTexts = text.split(SPLIT_REGEX);
        return new Tokens(getTokens(inputTexts));
    }

}