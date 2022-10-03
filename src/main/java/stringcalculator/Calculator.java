package stringcalculator;

public class Calculator {

    public String[] splitInput(String inputValue) {
        return inputValue.split(" ");
    }

    public void inputValueException(String splitValue) throws IllegalAccessException {
        if (splitValue == null || splitValue.isBlank()) {
            throw new IllegalAccessException();
        }
        if (splitValue != "+" || splitValue != "-" || splitValue != "/" || splitValue != "*") {
            throw new IllegalAccessException();
        }
    }

    public int sum(String[] numbers) {
        int sumResult = 0;
        for (String number : numbers) {
            sumResult += Integer.parseInt(number);
        }
        return sumResult;
    }

    public int subtraction(String[] numbers) {
        int subtractionResult = Integer.parseInt(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            subtractionResult -= Integer.parseInt(numbers[i]);
        }
        return subtractionResult;
    }

    public int multiplication(String[] numbers) {
        int multiplicationResult = 1;
        for (String number : numbers) {
            multiplicationResult *= Integer.parseInt(number);
        }
        return multiplicationResult;
    }

    public int division(String[] numbers) {
        int divisionResult = Integer.parseInt(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            divisionResult /= Integer.parseInt(numbers[i]);
        }
        return divisionResult;
    }

    public int calculatorSystem(String inputValue) throws IllegalAccessException {
        int calculateResult = 0;
        return calculateResult;
    }
}
