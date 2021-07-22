package string_add_calculator.tokenizer;

public class ExpressionTokenizer {
    private static final Tokenizer DEFAULT_TOKENIZER = new DefaultTokenizer();
    private static final CustomTokenizer CUSTOM_TOKENIZER = new CustomTokenizer();

    private ExpressionTokenizer() {}

    public static String[] split(String expression) {
        if (CUSTOM_TOKENIZER.isCustomExpression(expression)) {
            return CUSTOM_TOKENIZER.split(expression);
        }

        return DEFAULT_TOKENIZER.split(expression);
    }
}
