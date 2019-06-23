package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorStringTokenizerFactory {
    public static CalculatorStringTokenizer createTokenizer(String value) {
        Matcher m = Pattern.compile("^//(.)\n").matcher(value);
        if (m.find()) {
            return new CustomCalculatorStringTokenizer(value);
        }
        return new DefaultCalculatorStringTokenizer(value);
    }
}
