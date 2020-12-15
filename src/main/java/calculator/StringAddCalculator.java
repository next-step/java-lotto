package calculator;

public class StringAddCalculator {

    private StringAddCalculator() {
        throw new AssertionError();
    }

    public static int splitAndSum(String text) {
        int sum = 0;
        InputText inputText = new InputText(text);
        if (inputText.isEmpty()) {
            return sum;
        }
        SeparatorType separatorType = SeparatorType.findByInputText(inputText);
        Separator separator = separatorType.getSeparator();
        PositiveNumbers positiveNumbers = separator.split(inputText);
        return positiveNumbers.sum();
    }

}