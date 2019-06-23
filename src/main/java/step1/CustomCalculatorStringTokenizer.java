package step1;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomCalculatorStringTokenizer extends CalculatorStringTokenizer {

    public CustomCalculatorStringTokenizer(String value) {
        super(value);
    }

    @Override
    public List<String> split() {
        Matcher m = Pattern.compile("^//(.)\n(.*)").matcher(value);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return List.of(m.group(2).split(customDelimiter));
        }
        return List.of();
    }
}
