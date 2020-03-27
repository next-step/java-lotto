package calculator;

public class StringAddCalculator {
    private final String inputText;

    public StringAddCalculator(String inputText) {
        this.inputText = checkNullOrEmpty(inputText);
    }

    private String checkNullOrEmpty(String inputText) {
        if (inputText == null || inputText.trim().isEmpty()) {
            throw new IllegalArgumentException("공백이나 null이 입력되면 안됩니다.");
        }
        return inputText;
    }

}
