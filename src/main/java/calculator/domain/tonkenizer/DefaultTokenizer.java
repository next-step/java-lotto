package calculator.domain.tonkenizer;

public class DefaultTokenizer implements Tokenizer {
    private static final String REGEX = "[,|:]";

    @Override
    public String[] split(String input) {
        return input.split(REGEX);
    }

}

