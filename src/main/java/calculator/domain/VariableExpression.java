package calculator.domain;

public class VariableExpression{

    private final String string;

    public VariableExpression(String string) {
        this.string = string;
    }

    public int value(){
        return Integer.parseInt(string);
    }
}
