public class VariableExpression {

    private final char character;

    public VariableExpression(char character) {
        this.character = character;
    }

    public int calculate(){
        return Character.getNumericValue(character);
    }
}
