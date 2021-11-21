package stringaddcalculator;

public class Expression {

    private final String expresion;

    public Expression(String expresion) {
        this.expresion = expresion;
    }

    public boolean isNullOrEmpty() {
        return expresion == null || expresion.isEmpty();
    }
}
