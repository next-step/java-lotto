package calculator;

import delimiter.Delimiter;
import util.StringUtil;
import util.ValidationUtil;

import java.util.Arrays;

public class StringCalculator {

    Delimiter delimiter = new Delimiter();

    public int add(String text) {
        if(ValidationUtil.isBlank(text)){
            return 0;
        }
        return sum(StringUtil.textToInt(delimiter.splitByDelimiter(text)));
    }

    public int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
