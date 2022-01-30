package stringcalculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Number {

    private final List<String> userInput;

    public Number(List<String> userInput) {
        this.userInput = userInput;

    }

    public void checkIfPositiveNumber() {
        Pattern m = Pattern.compile("[0-9]+");
        for (String numStr : userInput) {
            if (!m.matcher(numStr).find()) {
                throw new RuntimeException();
            }
        }
    }

    public List<String>getNumberInput(){
        return new ArrayList<>(userInput);
    }
}

