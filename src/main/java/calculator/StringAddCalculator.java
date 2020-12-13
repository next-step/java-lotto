package calculator;

public final class StringAddCalculator {
    private static final int ZERO = 0;

    private StringAddCalculator() {
    }

    public static int splitAndSum(String text) {
        InputText input = new InputText(text);
        if(input.isEmpty()) return ZERO;

        Numbers numbers = Delimiter.split(input);
        if(numbers.hasNegativeNum()) {
            throw new RuntimeException();
        }
        if(numbers.hasOnlyOneNumber()) {
            return numbers.firstNumber();
        }

        return numbers.sum();
    }
}
