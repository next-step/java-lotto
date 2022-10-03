package stringcalculator;

public class Calculator {
    private String[] splitInputValues;
    private int frontNumber;
    private int backNumber;

    public String[] splitInput(String inputValue) throws IllegalAccessException {
        inputValueException(inputValue);
        return inputValue.split(" ");
    }

    public int sum(int frontNumber, int backNumber) {
        int sumResult = frontNumber + backNumber;
        return sumResult;
    }

    public int subtraction(int frontNumber, int backNumber) {
        int subtractionResult = frontNumber - backNumber;
        return subtractionResult;
    }

    public int multiplication(int frontNumber, int backNumber) {
        int multiplicationResult = frontNumber * backNumber;
        return multiplicationResult;
    }

    public int division(int frontNumber, int backNumber) {
        int divisionResult = frontNumber / backNumber;
        return divisionResult;
    }

    public void inputValueException(String splitValue) throws IllegalAccessException {
        if (splitValue == null || splitValue.isBlank()) {
            throw new IllegalAccessException();
        }
    }

    public void operatorException(String operator) throws IllegalAccessException {
        if (!(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/"))) {
            throw new IllegalAccessException();
        }
    }

    public void equationException() throws IllegalAccessException {
        if (splitInputValues.length % 2 == 0) {
            throw new IllegalAccessException();
        }
    }

    public int calculateValue(int inputValuePosition) throws IllegalAccessException {
        String operator = splitInputValues[inputValuePosition];
        operatorException(operator);
        return operateSelect(operator);
    }

    public int operateSelect(String operator) {
        if (operator.equals("+")) {
            return sum(frontNumber, backNumber);
        }
        if (operator.equals("-")) {
            return subtraction(frontNumber, backNumber);
        }
        if (operator.equals("*")) {
            return multiplication(frontNumber, backNumber);
        }
        return division(frontNumber, backNumber);
    }

    public int calculatorSystem() throws IllegalAccessException {
        int calculateInput = 0;
        frontNumber = Integer.parseInt(splitInputValues[0]);
        for (int i = 1; i < splitInputValues.length - 1; i = i + 2) {
            backNumber = Integer.parseInt(splitInputValues[i + 1]);
            calculateInput = calculateValue(i);
            frontNumber = calculateInput;
        }
        return calculateInput;
    }

    public int finalCalculate(String inputValue) throws IllegalAccessException {
        splitInputValues = splitInput(inputValue);
        if (splitInputValues.length == 1) {
            return Integer.parseInt(splitInputValues[0]);
        }
        equationException();
        return calculatorSystem();
    }
}
