package stringcalculator.model;

public class Calculator {

    public static final String SPACE = " ";
    private Operators operator;
    private Operands operand;

    public Calculator(String userInput) {
        this.isEmpty(userInput);
        String[] userInputArr = userInput.split(SPACE);
        this.operand = new Operands(userInputArr);
        this.operator = new Operators(userInputArr);
    }

    private void isEmpty(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("연산할 값을 입력해주세요.");
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
