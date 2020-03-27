package calculator;

public class StringAddCalculator {

    public int calculate(String inputText) {
        return checkNullOrEmpty(inputText);
    }

    private int checkNullOrEmpty(String inputText) {
        if (inputText == null || inputText.trim().isEmpty()) {
            return 0;
        }
        return parseToInt(inputText);
    }

    private int parseToInt(String inputText) {
        try {
            return (Integer.parseInt(inputText));
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자가 아닙니다. " + e.getMessage());
        }
    }

}
