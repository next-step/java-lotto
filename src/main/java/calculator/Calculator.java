package calculator;

public class Calculator {


    public static int calculate(String formula) {
        String[] formulaElements = formula.split(" ");
        int interimResult = getFirstElement(formulaElements);
        for(int i = 1; i < formulaElements.length; i += 2) {
            interimResult = calculate(interimResult, getOperator(i, formulaElements), getOperand(i, formulaElements));
        }
        return interimResult;
    }

    private static int getFirstElement(String[] formulaElements) {
        return Integer.parseInt(formulaElements[0]);
    }

    private static int calculate(int operand1, String operator, int operand2) {
        switch(operator) {
            case "+" :
                return operand1 + operand2;
            case "-" :
                return operand1 - operand2;
            case "*" :
                return operand1 * operand2;
            case "/" :
                return operand1 / operand2;
        }
        return 0;
    }

    private static String getOperator(int index, String[] formulaElements) {
        return formulaElements[index];
    }

    private static int getOperand(int index, String[] formulaElements) {
        return Integer.parseInt(formulaElements[index + 1]);
    }
}
