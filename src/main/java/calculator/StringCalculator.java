package calculator;

import delimiter.Delimiter;
import util.StringUtil;

import java.util.Arrays;

public class StringCalculator {
    public static int add(String text) {
        return sum(StringUtil.textToInt(Delimiter.splitByDelimiter(text)));
    }

    public static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
