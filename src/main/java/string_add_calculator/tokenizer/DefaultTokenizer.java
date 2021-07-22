package string_add_calculator.tokenizer;

public class DefaultTokenizer implements Tokenizer {

    public String[] split(String inputString) {
        return inputString.split("[,|:]");
    }
}
