package Calculator.Model;

import Util.CheckInput;

public class Calculator {
    private static final Integer INDEX_CALCULATE_CURRENT_ELEMENT = 0;
    private static final Integer INDEX_CALCULATE_OPERATOR = 1;

    private static final String INITIAL_NUMBER_BEFORE_ARGUMENT = "0";
    private static final String INITIAL_OPERATOR = "+";

    private final String[] results;

    public Calculator() {
        results = new String[2];
        results[INDEX_CALCULATE_CURRENT_ELEMENT] = INITIAL_NUMBER_BEFORE_ARGUMENT;
        results[INDEX_CALCULATE_OPERATOR] = INITIAL_OPERATOR;
    }

    public void type(String element) {
        String current = currentResult();
        String operator = currentOpretor();

        if (CheckInput.isNumeric(element)) {
            execute(current, operator, element);
        }else if (CheckInput.isOperator(element)) {
            changeOperator(element);
        }
    }

    public void execute(String numberStringBeforeArgument, String operator, String numberStringAfterArgument) {
        int numBefore = Integer.parseInt(numberStringBeforeArgument);
        int numAfter = Integer.parseInt(numberStringAfterArgument);

        int result = numBefore;
        switch (operator) {
            case "+":
                result = (numBefore + numAfter);
                break;
            case "-":
                result = (numBefore - numAfter);
                break;
            case "*":
                result = (numBefore * numAfter);
                break;
            case "/":
                result = (numBefore / numAfter);
                break;
        }

        results[INDEX_CALCULATE_CURRENT_ELEMENT] = String.valueOf(result);
    }

    public void changeOperator(String operator) {
        results[INDEX_CALCULATE_OPERATOR] = operator;
    }

    public String currentResult() {
        return results[INDEX_CALCULATE_CURRENT_ELEMENT];
    }

    public String currentOpretor() {
        return results[INDEX_CALCULATE_OPERATOR];
    }
}
