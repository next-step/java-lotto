package calculator.domain;

import java.util.Objects;

public class StringCalculator {

    private static final String RETURN_NUMBER_ZERO = "0";

    private String input;

    public StringCalculator(String input) {
        this.input = validateEmptyOrNull(input);
    }

    public int add() {
        Parser parser = new Parser(input);
        String splitedFormular = parser.getParsedFormular();

        if (!Objects.isNull(parser.getCustomDelimiter())) {
            String delimeter = parser.getCustomDelimiter();
            return Parser.makeToIntegerList(splitedFormular, delimeter + "|,|:").stream()
                .mapToInt(Integer::intValue)
                .sum();
        }

        return Parser.makeToIntegerList(input, ",|:").stream()
            .mapToInt(Integer::intValue)
            .sum();
    }

    private String validateEmptyOrNull(String input) {
        if (Objects.isNull(input) || "".equals(input)) {
            input = RETURN_NUMBER_ZERO;
        }
        return input;
    }
}
