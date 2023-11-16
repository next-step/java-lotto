package calculator.domain;

public class VariableExpression{

    private final String string;

    private VariableExpression(String string) {
        this.string = string;
    }

    public static VariableExpression of(String string){
        return new VariableExpression(string);
    }


    public int value(){
        return Integer.parseInt(string);
    }
}
