package calculator;

import calculator.delimiter.StringDelimiter;
import calculator.domain.Numbers;
import calculator.util.ValidationUtil;

public class StringCalculator {

    public int splitAndSum(String text) {
        if (ValidationUtil.isBlank(text)) {
            return 0;
        }

        String[] texts = StringDelimiter.splitByDelimiter(text);
        Numbers numbers = new Numbers(texts);

        return numbers.sum();
    }

}
