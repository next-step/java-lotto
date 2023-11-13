package stringcalculator.model;

public class Calculator {

    private Operator operator;
    private Operand operand;
    public Calculator(String userInput) {
        this.isEmpty(userInput);
    }

    public void isEmpty(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

}
