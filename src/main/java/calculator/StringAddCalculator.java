package calculator;

public class StringAddCalculator {

    public StringAddCalculator() {
    }

    public int calculate(String inputText) {
        checkNullOrEmpty(inputText);
        return 0;
    }


    private String checkNullOrEmpty(String inputText) {
        if (inputText == null || inputText.trim().isEmpty()) {
            throw new IllegalArgumentException("공백이나 null이 입력되면 안됩니다.");
        }
        return inputText;
    }



}
