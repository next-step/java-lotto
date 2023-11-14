package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CharacterParser {


    public List<String> parsingFormula(String input) {
        isNullAndBlank(input);
        String[] formula = input.split(" ");
        List<String> parsingList = new ArrayList<>();
        for (String character : formula) {
            validateOperator(character);
            parsingList.add(character);
        }
        return parsingList;
    }

    private void isNullAndBlank(String input) {
        if (Objects.isNull(input) || input.isBlank() || input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateOperator(String character) {
        if (character.chars().allMatch(CharacterParser::isParsingNumber))
            return;
        if(!Operator.isBasicOperation(character))
            throw new IllegalArgumentException();
    }

    private static boolean isParsingNumber(int value) {
        return value >= '0' && value <= '9';
    }


}
