package tdd;

import static tdd.Numbers.INIT_RESULT_VALUE;

public class StringAddCalculator {

    public int add(String inputText) {
        if (inputText == null || inputText.isEmpty()) {
            return INIT_RESULT_VALUE;
        }

        Numbers numbers = new Numbers(InputParser.parseToNumberTexts(inputText));
        return numbers.addAll();
    }
}
