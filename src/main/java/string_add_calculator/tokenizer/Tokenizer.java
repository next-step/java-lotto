package string_add_calculator.tokenizer;

public class Tokenizer {
    public static String[] split(String inputString) {
        return inputString.split("[,|:]");
    }
}
