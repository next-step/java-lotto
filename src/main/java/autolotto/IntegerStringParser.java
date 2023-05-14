package autolotto;

import calculator.parser.converter.StringConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerStringParser {
    private final String delimiter;
    private final StringConverter<Integer> stringToIntegerConverter;

    public IntegerStringParser(String delimiter, StringConverter<Integer> stringToIntegerConverter) {
        this.delimiter = delimiter;
        this.stringToIntegerConverter = stringToIntegerConverter;
    }

    public List<Integer> parse(String input) {
        return Arrays.stream(input.split(delimiter))
                .map(stringToIntegerConverter::convert)
                .collect(Collectors.toList());
    }
}
