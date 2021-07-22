package string_add_calculator.tokenizer;

public class DefaultTokenizer implements Tokenizer {
    private static final String SPLIT_REGEX = "[,|:]";

    @Override
    public String[] split(String expression) {
        return expression.split(SPLIT_REGEX);
    }
}
