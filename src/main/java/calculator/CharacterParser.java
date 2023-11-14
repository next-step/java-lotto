package calculator;

import java.util.Objects;

public class CharacterParser {


    public void parsingFormula(String input) {
        isNullAndBlank(input);
    }

    private void isNullAndBlank(String input) {
        if (Objects.isNull(input) || input.isBlank() || input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
