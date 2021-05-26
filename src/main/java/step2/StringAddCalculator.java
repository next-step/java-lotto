package step2;

import java.util.List;

import lotto.tool.Tokenizer;

public final class StringAddCalculator {

    private StringAddCalculator() {
    }

    public static int compute(String text) {
        if (Tokenizer.isEmpty(text)) {
            return 0;
        }
        return sum(Tokenizer.captureNumbers(text));
    }

    private static int sum(List<String> numbers) {
        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }

}
