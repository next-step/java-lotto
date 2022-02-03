package domain;

import util.ValidateInput;

public class StringCalculator {

    int total;

    public int add(String text) {
        String input = new ValidateInput(text).getYourInput();
        Parser parser = new Parser(input);
        String isCustomalize = parser.customSplit(input);
        if ("".equals(isCustomalize)) {
            total = parser.splitStringToNumber().stream().mapToInt(Integer::intValue).sum();
        } else {
            total = parser.customSplitStringToNumber(isCustomalize).stream()
                .mapToInt(Integer::intValue).sum();
        }

        return total;
    }
}
