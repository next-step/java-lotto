package calculator.domain;

public class VariableExpression{

    private final char character;

    public VariableExpression(char character) {
        this.character = character;
    }

    public int value(){
        return Character.getNumericValue(character);
    }
}
