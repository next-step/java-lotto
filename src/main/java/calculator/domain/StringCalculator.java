package calculator.domain;

import java.util.List;
import calculator.util.ValidateInput;

public class StringCalculator {

    private final static int SPLITED_FORMULAR_POSITION = 0;
    private final static int CUSTOM_FORMULAR_SIZE = 2;
    private final static int DELIMITER_POSITON = 1;
    private int total;

    public int add(String text) {
        String input = new ValidateInput(text).getYourInput();
        Parser parser = new Parser();
        List<String> customSymbolAndFormula = parser.splitCustom(input);
        String splitedFormular = customSymbolAndFormula.get(SPLITED_FORMULAR_POSITION);

        if (customSymbolAndFormula.size() == CUSTOM_FORMULAR_SIZE) {
            String delimeter = customSymbolAndFormula.get(DELIMITER_POSITON);
            total = parser.splitCustomStringToNumber(splitedFormular, delimeter + "|,|:").stream()
                .mapToInt(Integer::intValue).sum(); // 여기를 커스텀구분자
        } else {
            total = parser.splitCustomStringToNumber(splitedFormular, ",|:").stream()
                .mapToInt(Integer::intValue).sum();
        }

        return total;
    }
}
