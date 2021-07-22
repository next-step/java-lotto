package string_add_calculator.tokenizer;

public class ExpressionTokenizer {

    private static final Tokenizer DEFAULT_TOKENIZER = new DefaultTokenizer();

    private ExpressionTokenizer() {}

    public static String[] split(String inputString) {
        return DEFAULT_TOKENIZER.split(inputString);
    }
}
