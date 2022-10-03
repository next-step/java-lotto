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

    public int sum(String[] numbers){
        int sumResult = 0;
        return sumResult;
    }

    public int subtraction(){
        int subtractionResult = 0;
        return subtractionResult;
    }

    public int multiplication(){
        int multiplicationResult = 0;
        return multiplicationResult;
    }

    public int division(){
        int divisionReusult = 0;
        return divisionReusult;
    }

    public int calculatorSystem(String inputValue) throws IllegalAccessException {
        int calculateResult = 0;
        return calculateResult;
    }
}
