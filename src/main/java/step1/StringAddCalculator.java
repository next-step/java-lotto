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

    public int calculate (String input) {
        if(input == null|| input.equals("")){
            return 0;
        }
      return sum(split(input));
    }

    public String[] split(String input) {
        String delimiter = stringParser.setDelimiter(input);
        return stringParser.parse(delimiter);
    }

    public int sum (String[] stringNumbers) {
        List<Integer> numbers = positiveNumber.toInt(stringNumbers);
        return positiveNumber.sum(numbers);
    }
}
