package calculator.domain;

import java.util.List;
import java.util.Objects;

public class StringCalculator {

    private final static int SPLITED_FORMULAR_POSITION = 0;
    private final static int CUSTOM_FORMULAR_SIZE = 2;
    private final static int DELIMITER_POSITON = 1;
    private String input;

    public StringCalculator(String input) {
        this.input = isEmptyOrNull(input);
    }

    public int add() {
        Parser parser = new Parser(input);
        String splitedFormular = parser.getParsedFormular();

        if (!Objects.isNull(parser.getCustomDelimiter())) {
            String delimeter = parser.getCustomDelimiter();
            return Parser.splitCustomStringToNumber(splitedFormular, delimeter + "|,|:").stream()
                .mapToInt(Integer::intValue).sum();
        }

        return Parser.splitCustomStringToNumber(input, ",|:").stream()
            .mapToInt(Integer::intValue).sum();
    }

    private String isEmptyOrNull(String input) {
        if (Objects.isNull(input) || "".equals(input)) {
            input = "0";
        }
        return input;
    }
}
