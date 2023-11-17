package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CharacterParser {

    public static final String DELIMITER = " ";
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
        String[] formula = input.split(DELIMITER);
        for (int index = 0; index < formula.length; index++) {
            classifyExpression(index, formula[index]);
        }
    }

    private void isNullAndBlank(String input) {
        if (Objects.isNull(input) || input.isBlank() || input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void classifyExpression(int index, String input) {
        if (index % 2 == 0) {
            classifyOperands(input);
            return;
        }
        classifyOperators(input);
    }

    private void classifyOperators(String input) {
        operators.add(Operator.findSymbol(input));
    }

    private void classifyOperands(String input) {
        operands.add(Integer.parseInt(input));
    }


}
