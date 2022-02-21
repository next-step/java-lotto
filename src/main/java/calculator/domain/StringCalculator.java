package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StringCalculator {
    private static final String SPLITER = ",|:";
    private static final String CUSTOM_SPLITER = "|,|:";
    private static final String RETURN_NUMBER_ZERO = "0";

    private String input;

    public StringCalculator(String input) {
        this.input = validateEmptyOrNull(input);
    }

    private String validateEmptyOrNull(String input) {
        if (Objects.isNull(input) || "".equals(input)) {
            input = RETURN_NUMBER_ZERO;
        }
        return input;
    }

    public int add() {
        Parser parser = new Parser(input);
        if (Objects.isNull(parser.getCustomDelimiter())) {
            List<String> numbers = Arrays.asList(parser.getParsedFormular().split(SPLITER));
            return parser.refineToIntegerList(numbers).stream()
                .mapToInt(Integer::intValue)
                .sum();
        }

        String delimeter = parser.getCustomDelimiter();
        List<String> numbers = Arrays.asList(parser.getParsedFormular().split(delimeter + CUSTOM_SPLITER));
        return parser.refineToIntegerList(numbers).stream()
            .mapToInt(Integer::intValue)
            .sum();
    }

}
