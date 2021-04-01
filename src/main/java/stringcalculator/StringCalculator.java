package stringcalculator;

public final class StringCalculator {

    public static int sum(String input) {
        InputNumbers inputNumbers = new InputNumbers(input);
        OperandIntegers operandIntegers = new OperandIntegers(inputNumbers.numbers());
        return operandIntegers.sum();
    }
}
