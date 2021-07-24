package calculator.stringadder.fixture;

import calculator.stringadder.tokenizer.CustomTokenizer;
import calculator.stringadder.tokenizer.DefaultTokenizer;
import calculator.stringadder.tokenizer.Tokenizer;

public class Fixture {
    public static Tokenizer DEFAULT_TOKENIZER = new DefaultTokenizer();
    public static CustomTokenizer CUSTOM_TOKENIZER = new CustomTokenizer();

    private Fixture() {}
}
