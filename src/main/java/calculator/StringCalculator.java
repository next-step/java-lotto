package calculator;

import calculator.delimiter.StringDelimiter;
import calculator.util.StringUtil;
import calculator.util.ValidationUtil;

import java.util.List;

public class StringCalculator {

    public int add(String text) {
        if(ValidationUtil.isBlank(text)){
            return 0;
        }
        return sum(StringUtil.textToInt(StringDelimiter.splitByDelimiter(text)));
    }

    public int sum(List<Integer> numbers) {
        return numbers.stream()
            .reduce(0, Integer::sum);
    }
}
