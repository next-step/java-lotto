package step1;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class StringAddCalculator {

    private final PositiveNumber positiveNumber;
    private final StringParser stringParser;

    public StringAddCalculator() {
        this.positiveNumber = new PositiveNumber();
        this.stringParser = new StringParser();
    }

    public int splitAndSum(String input) {
        if (StringUtils.isBlank(input)) {
            return 0;
        }
        String delimiter = stringParser.setDelimiter(input);
        String[] parse = stringParser.parse(delimiter);
        List<Integer> numbers = positiveNumber.toInt(parse);
        return positiveNumber.add(numbers);
    }
}
