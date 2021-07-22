package string_add_calculator.fixture;

import string_add_calculator.tokenizer.CustomTokenizer;
import string_add_calculator.tokenizer.DefaultTokenizer;
import string_add_calculator.tokenizer.Tokenizer;

public class Fixture {
    public static Tokenizer DEFAULT_TOKENIZER = new DefaultTokenizer();
    public static Tokenizer CUSTOM_TOKENIZER = new CustomTokenizer();

    private Fixture() {}
}
