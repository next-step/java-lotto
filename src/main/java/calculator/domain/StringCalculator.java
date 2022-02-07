package calculator.domain;

import java.util.List;
import java.util.Objects;

public class StringCalculator {

    private final static int SPLITED_FORMULAR_POSITION = 0;
    private final static int CUSTOM_FORMULAR_SIZE = 2;
    private final static int DELIMITER_POSITON = 1;
    private int total;
    private String input;

    public StringCalculator(String input) {
        this.input = isEmptyOrNull(input);
    }

    public int add() {
        Parser parser = new Parser();
        List<String> customSymbolAndFormula = parser.splitCustom(input);
        String splitedFormular = customSymbolAndFormula.get(SPLITED_FORMULAR_POSITION);

        if (customSymbolAndFormula.size() == CUSTOM_FORMULAR_SIZE) {
            String delimeter = customSymbolAndFormula.get(DELIMITER_POSITON);
            total = parser.splitCustomStringToNumber(splitedFormular, delimeter + "|,|:").stream()
                .mapToInt(Integer::intValue).sum();
        } else {
            total = parser.splitCustomStringToNumber(splitedFormular, ",|:").stream()
                .mapToInt(Integer::intValue).sum();
        }

        return total;
    }

    private String isEmptyOrNull(String input) {
        if (Objects.isNull(input) || "".equals(input)) {
            input = "0";
        }
        return input;
    }
}
