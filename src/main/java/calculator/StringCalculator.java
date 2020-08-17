package calculator;

import delimiter.StringDelimiter;
import util.StringUtil;
import util.ValidationUtil;

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
