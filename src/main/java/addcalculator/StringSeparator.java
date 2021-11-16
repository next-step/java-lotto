package addcalculator;

import addcalculator.domain.Number;
import addcalculator.domain.Numbers;
import addcalculator.exception.NotInstanceException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringSeparator {

    private static final String COMMA_OR_COLON = "[,:]";

    private StringSeparator() {
        throw new NotInstanceException();
    }

    public static Numbers separate(String text) {
        String[] stringNumbers = text.split(COMMA_OR_COLON);

        List<Number> numbers = Arrays.stream(stringNumbers)
                .map(Number::of)
                .collect(Collectors.toList());
        return Numbers.of(numbers);
    }

    public static Numbers separateFromCustomDelimiter(String text, String delimiter) {
        String[] stringNumbers = text.split(delimiter);

        List<Number> numbers = Arrays.stream(stringNumbers)
                .map(Number::of)
                .collect(Collectors.toList());
        return Numbers.of(numbers);
    }
}
