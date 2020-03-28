package calculator;

public class StringAddCalculator {

    public int calculate(String inputText) {
        if (inputText == null || inputText.trim().isEmpty()) {
            return 0;
        }

        TextToNumber textToNumber = new TextToNumber(inputText);
        return textToNumber.sum();
    }

}
