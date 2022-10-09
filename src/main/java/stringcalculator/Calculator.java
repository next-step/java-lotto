package stringcalculator;

public class Calculator {
    private String[] splitInputValues;

    private String[] splitInput(String inputValue) {
        validateNullValue(inputValue);
        return inputValue.split(" ");
    }

    private void validateNullValue(String splitValue) {
        if (splitValue == null || splitValue.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateOperate(String operator) {
        if (!(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/"))) {
            throw new IllegalArgumentException();
        }
    }

    private void validateEquation() {
        if (splitInputValues.length % 2 == 0) {
            throw new IllegalArgumentException();
        }
    }

    private int calculateValue(int inputValuePosition, int frontNumber, int backNumber) {
        String operator = splitInputValues[inputValuePosition];
        validateOperate(operator);
        return selectOperate(operator, frontNumber, backNumber);
    }

    private int selectOperate(String operator, int frontNumber, int backNumber) {
        Operate operate = Operate.findOperator(operator);
        return operate.calculateNumbers(frontNumber, backNumber);
    }

    private int calculatorSystem() {
        int calculateInput = 0;
        int frontNumber = Integer.parseInt(splitInputValues[0]);
        int backNumber = 0;
        for (int i = 1; i < splitInputValues.length - 1; i = i + 2) {
            backNumber = Integer.parseInt(splitInputValues[i + 1]);
            calculateInput = calculateValue(i, frontNumber, backNumber);
            frontNumber = calculateInput;
        }
        return calculateInput;
    }

    public int finalCalculate(String inputValue) {
        splitInputValues = splitInput(inputValue);
        if (splitInputValues.length == 1) {
            return Integer.parseInt(splitInputValues[0]);
        }
        validateEquation();
        return calculatorSystem();
    }
}
