package step1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSum {

    private final String reg;

    public StringSum(String reg) {
        this.reg = reg;
    }

    public Result sum(String input) {
        if (isEmpty(input)) {
            return new Result(0);
        }
        String[] numbers = split(input);
        Integer sum = sumString(numbers);
        return new Result(sum);
    }

    private boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private String[] split(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return input.split(reg);
    }

    private Integer sumString(String[] numbers) {
        return Arrays.stream(numbers)
            .map(string -> {
                int number = Integer.parseInt(string);
                if (number < 0) {
                    throw new RuntimeException();
                }
                return number;
            })
            .reduce(0, Integer::sum);
    }
}
