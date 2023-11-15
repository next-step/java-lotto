package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CharacterParser {

    private List<Integer> operands = new ArrayList<>();
    private List<Operator> operators = new ArrayList<>();

    public CharacterParser() {}

    public CharacterParser(List<Integer> operands, List<Operator> operators) {
        this.operands = operands;
        this.operators = operators;
    }

    public List<Integer> operands() {
        return operands;
    }

    public List<Operator> operators() {
        return operators;
    }

    public void parsingFormula(String input) {
        isNullAndBlank(input);
        String[] formula = input.split(" ");
        for (String character : formula) {
            classifyExpression(character);
        }
    }

    private void isNullAndBlank(String input) {
        if (Objects.isNull(input) || input.isBlank() || input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void classifyExpression(String character) {
        if (character.chars().allMatch(CharacterParser::isParsingNumber)){
            operands.add(Integer.parseInt(character));
            return;
        }
        operators.add(Operator.findSymbol(character));
    }

    private static boolean isParsingNumber(int value) {
        return value >= '0' && value <= '9';
    }


}
