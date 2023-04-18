package Calculator.Model;

import Util.CheckInput;

import java.util.ArrayList;

public class Calculator {
    private static final Integer INDEX_CALCULATE_CURRENT_ELEMENT = 0;
    private static final Integer INDEX_CALCULATE_OPERATOR = 1;
    private static final Integer INDEX_CALCULATE_NEW_ELEMENT = 2;

    public ArrayList<String> calculate(ArrayList<String> results) {
        String currentResult = getCurrentResult(results);
        String operator = getCurrentOpretor(results);
        String element = getNewInput(results);

        ArrayList<String> list = new ArrayList<>();
        if (CheckInput.isNumeric(element)) {
            list.add(callCalculator(currentResult, operator, element));
            list.add(operator);
            return list;
        }

        if (CheckInput.isOperator(element)) {
            list.add(currentResult);
            list.add(element);
            return list;
        }

        return list;
    }

    public String callCalculator(String numberStringBeforeArgument, String operator, String numberStringAfterArgument) {
        int numBefore = Integer.parseInt(numberStringBeforeArgument);
        int numAfter = Integer.parseInt(numberStringAfterArgument);
        switch (operator) {
            case "+" :
                return String.valueOf(Calculator.add(numBefore, numAfter));
            case "-" :
                return String.valueOf(Calculator.subtract(numBefore, numAfter));
            case "*" :
                return String.valueOf(Calculator.multiple(numBefore, numAfter));
            case "/" :
                return String.valueOf(Calculator.divide(numBefore, numAfter));
        }

        return "0";
    }

    public String getCurrentResult(ArrayList<String> results) {
        return results.get(INDEX_CALCULATE_CURRENT_ELEMENT);
    }

    public String getCurrentOpretor(ArrayList<String> results) {
        return results.get(INDEX_CALCULATE_OPERATOR);
    }

    public String getNewInput(ArrayList<String> results) {
        return results.get(INDEX_CALCULATE_NEW_ELEMENT);
    }

    private static int add(int a, int b) {
        return a + b;
    }

    private static int subtract(int a, int b) {
        return a - b;
    }

    private static int multiple(int a, int b) {
        return a * b;
    }

    private static int divide(int a, int b) {
        return a / b;
    }
}
