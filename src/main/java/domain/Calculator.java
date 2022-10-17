package domain;

public class Calculator {

    private static final String SPACE = " ";
    private String[] input;

    public Calculator(String input) {
        if (isValid(input)) {
            throw new IllegalArgumentException("빈 값을 입력할 수 없습니다.");
        }
        this.input = input.split(SPACE);
    }

    private boolean isValid(String input) {
        return input == null || input.isEmpty();
    }
}
