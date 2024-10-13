package calculator;

public class StringCalculator {
    public static final String DELIMITER = " ";

    public static int calculate(String input) {
        InputValidator.validate(input);
        String[] inputItems = input.split(DELIMITER);
        OperationElements operationElements = new OperationElements();

        for (String item : inputItems) {
            operationElements.putOperationElement(item);
        }

        return operationElements.operate();
    }
}
