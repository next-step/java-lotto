package domain;

import java.util.List;
import util.ValidateInput;

public class StringCalculator {

    private final static int SPLITED_FORMULAR_POSITION = 0;
    private final static int CUSTOM_FORMULAR_SIZE = 2;
    private final static int DELIMITER_POSITON = 1;
    private int total;

    public int add(String text) {
        String input = new ValidateInput(text).getYourInput();
        Parser parser = new Parser(input);
        List<String> isCustomalize = parser.customSplit(input);
        String splitedFormular = isCustomalize.get(SPLITED_FORMULAR_POSITION);

        if (isCustomalize.size() == CUSTOM_FORMULAR_SIZE) {
            String delimeter = isCustomalize.get(DELIMITER_POSITON);
            total = parser.customSplitStringToNumber(splitedFormular, delimeter + "|,|:").stream()
                .mapToInt(Integer::intValue).sum(); // 여기를 커스텀구분자
        } else {
            total = parser.customSplitStringToNumber(splitedFormular, ",|:").stream()
                .mapToInt(Integer::intValue).sum();
        }

        return total;
    }
}
