package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StringCalculator {

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
        List<String> refinedFormular;

        if (!Objects.isNull(parser.getCustomDelimiter())) {
            String delimeter = parser.getCustomDelimiter();
            refinedFormular = Arrays.asList(parser.getParsedFormular().split(delimeter + "|,|:"));
            return parser.refineToIntegerList(refinedFormular).stream()
                .mapToInt(Integer::intValue)
                .sum();
        }

        refinedFormular = Arrays.asList(parser.getParsedFormular().split(",|:"));

        return parser.refineToIntegerList(refinedFormular).stream()
            .mapToInt(Integer::intValue)
            .sum();
    }

}
