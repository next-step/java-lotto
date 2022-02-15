package calculator.domain;

import calculator.util.ValidateInput;
import java.util.List;

public class StringCalculator {

    private final static int SPLITED_FORMULAR_POSITION = 0;
    private final static int CUSTOM_FORMULAR_SIZE = 2;
    private final static int DELIMITER_POSITON = 1;
    private int total;

    public int add(String text) {
        String input = new ValidateInput(text).getYourInput();
        Parser parser = new Parser();
        List<String> customSymbolAndFormula = parser.parseCustomDelimiterAndFormula(input);
        String splitedFormular = customSymbolAndFormula.get(SPLITED_FORMULAR_POSITION);

        if (customSymbolAndFormula.size() == CUSTOM_FORMULAR_SIZE) {
            String delimeter = customSymbolAndFormula.get(DELIMITER_POSITON);
            total = parser.customSplitStringToNumber(splitedFormular, delimeter + "|,|:").stream()
                .mapToInt(Integer::intValue).sum(); // 여기를 커스텀구분자
        } else {
            total = parser.customSplitStringToNumber(splitedFormular, ",|:").stream()
                .mapToInt(Integer::intValue).sum();
        }

        return total;
    }
}
