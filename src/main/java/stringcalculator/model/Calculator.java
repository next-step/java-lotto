package stringcalculator.model;

public class Calculator {

    public static final String SPACE = " ";
    private Operator operator;
    private Operand operand;

    public Calculator(String userInput) {
        this.isEmpty(userInput);
        String[] userInputArr = userInput.split(SPACE);
        this.operand = new Operand(userInputArr);
        this.operator = new Operator(userInputArr);
    }

    private void isEmpty(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public int calculate() {
        int result = operand.pop();
        while(operand.hasNext()) {
            result = operator.operate(result, operand.pop());
        }
        return result;
    }

}
