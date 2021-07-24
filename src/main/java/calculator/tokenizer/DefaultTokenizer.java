package calculator.tokenizer;

public class DefaultTokenizer implements Tokenizer {
    private static final String DEFAULT_DELIMITER_PATTERN = "[,:]"; // 기본 구분자는 쉼표(,)와 콜론(:)

    @Override
    public String[] tokenize(String str) {
        return str.split(DEFAULT_DELIMITER_PATTERN);
    }
}
