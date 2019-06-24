package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Splitter {
    private static final String REGEX_OF_DEFAULT_SEPARATOR = "[,:]";
    private static final String REGEX_OF_CUSTOM_SEPARATOR = "//(.)\n(.*)";

    static List<Operand> extractOperands(String input) {
        if (isEmpty(input)) {
            Operand operand = Operand.of(Operand.MINIMUM_VALUE);
            return Collections.singletonList(operand);
        }

        String[] elementsOnInput = split(input);
        List<Operand> operands = Arrays.stream(elementsOnInput)
                .map(Operand::of)
                .collect(Collectors.toList());

        return Collections.unmodifiableList(operands);
    }

    private static boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private static String[] split(String input) {
        String[] elementsOnInput = input.split(REGEX_OF_DEFAULT_SEPARATOR);

        Matcher matcher = Pattern.compile(REGEX_OF_CUSTOM_SEPARATOR).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            elementsOnInput = matcher.group(2).split(customDelimiter);
        }
        return elementsOnInput;
    }
}
