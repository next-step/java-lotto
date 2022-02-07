package stringcalculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Number {

    private final List<String> userInput;

    public Number(final List<String> userInput) {
        checkPositiveNumbers(userInput);
        this.userInput = userInput;

    }

    private void checkPositiveNumbers(final List<String> userInput) {
        Pattern pattern = Pattern.compile("[0-9]+");
        for (String numStr : userInput) {
            checkPositiveNumber(pattern, numStr);
        }
    }

    private void checkPositiveNumber(Pattern m, String numStr) {
        if (!m.matcher(numStr).find()) {
            throw new RuntimeException(String.format("inputValue: %s 양수의 값을 입력해 주세요.", numStr));
        }
    }

    public List<String> getNumberInput() {
        return new ArrayList<>(userInput);
    }
}

