package calculator;

public class StringAddCalculator {

    public int calculate(String inputText) {
        if (inputText == null || inputText.trim().isEmpty()) {
            return 0;
        }
        TextToNumber convertNumber = new TextToNumber(inputText);
        PostiveNumbers postiveNumbers = new PostiveNumbers(convertNumber);

        return postiveNumbers.sum();
    }

}
