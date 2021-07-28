package calculator.domain.tonkenizer;

public class TokenizeOperator {
    private static final Tokenizer DEFAULT_TOKENIZER = new DefaultTokenizer();
    private static final CustomTokenizer CUSTOM_TOKENIZER = new CustomTokenizer();

    private TokenizeOperator() {}

    public static String[] split(String input) {
        if (CustomTokenizer.isCustomExpression(input)) {
            return CUSTOM_TOKENIZER.split(input);
        }

        return DEFAULT_TOKENIZER.split(input);
    }

}
