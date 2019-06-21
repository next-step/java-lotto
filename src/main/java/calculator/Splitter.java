package calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private static final String REGEX_OF_DEFAULT_SEPARATOR = "[,:]";
    private static final String REGEX_OF_CUSTOM_SEPARATOR = "//(.)\n(.*)";

    public List<Operand> extractOperands(String input) {
        if (isEmpty(input)) {
            Operand zero = Operand.of(0);
            return Collections.singletonList(zero);
        }

        List<Operand> operands = new ArrayList<>();
        String[] elementsOnInput = split(input);

        for (String element : elementsOnInput) {
            Operand operand = Operand.of(element);
            operands.add(operand);
        }
        return Collections.unmodifiableList(operands);
    }

    private boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private String[] split(String input) {
        String[] elementsOnInput = input.split(REGEX_OF_DEFAULT_SEPARATOR);

        Matcher matcher = Pattern.compile(REGEX_OF_CUSTOM_SEPARATOR).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            elementsOnInput = matcher.group(2).split(customDelimiter);
        }
        return elementsOnInput;
    }
}
