package calculator;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        int sum = 0;
        InputText inputText = new InputText(text);
        if (inputText.isEmpty()) {
            return sum;
        }
        Separator separator = new DefaultSeparator();
        if (CustomSeparator.hasCustomSeparator(inputText)) {
            separator = new CustomSeparator();
        }
        Tokens tokens = separator.split(inputText);
        return tokens.sum();
    }

}