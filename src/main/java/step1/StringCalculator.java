package step1;

public class StringCalculator {

        private String input;

    public StringCalculator(String input) {
        this.input = input;
        inputCheck(input);
    }

    private void inputCheck(String input) {
        if(nullOrWhiteSpaceInput(input)){
            throw new IllegalArgumentException("입력 문자열은 null 또는 빈 문자열이어서는 안됩니다.");
        }
    }

    private static boolean nullOrWhiteSpaceInput(String input) {
        return input == null || input.trim().isEmpty();
    }

    public int add(int first, int second) {
        return first + second;
    }

    public int subtract(int first, int second) {
        return first - second;
    }

    public int multiply(int first, int second) {
        return first * second;
    }

    public int divide(int first, int second) {
        return first / second;
    }
}
