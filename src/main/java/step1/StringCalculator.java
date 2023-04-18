package step1;

import java.util.List;

public class StringCalculator {

    private final StringSeparator stringSeparator;

    public StringCalculator(StringSeparator stringSeparator) {
        this.stringSeparator = stringSeparator;
    }

    public int calculate(String input) {
        List<String> numbersAndOperators = stringSeparator.separateByDelimiter(input);
        return 1;
    }
}
