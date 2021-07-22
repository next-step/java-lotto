package string_add_calculator.tokenizer;

public class DefaultTokenizer implements Tokenizer {
    private static final String SPLIT_REGEX = "[,|:]";

    @Override
    public String[] split(String inputString) {
        return inputString.split(SPLIT_REGEX);
    }
}
