package stringcalculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Number {

    private final List<String> userInput;

    public Number(List<String> userInput) {
        checkIfPositiveNumber(userInput);
        this.userInput = userInput;

    }

    private void checkIfPositiveNumber(List<String> userInput) {
        Pattern m = Pattern.compile("[0-9]+");
        for (String numStr : userInput) {
            if (!m.matcher(numStr).find()) {
                throw new RuntimeException("양수의 값을 입력해 주세요.");
            }
        }
    }

    public List<String> getNumberInput() {
        return new ArrayList<>(userInput);
    }
}

