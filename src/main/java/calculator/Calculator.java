package calculator;

public class Calculator {

    public int add(int input1, int input2) {
        return input1 + input2;
    }

    public int minus(int input1, int input2) {
        return input1 - input2;
    }

    public int multiply(int input1, int input2) {
        return input1 * input2;
    }

    public int divide(int input1, int input2) {
        return input1 / input2;
    }

    public int validate(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("null 또는 빈 문자열은 입력할 수 없습니다.");
        }
        return Integer.parseInt(input);
    }
}
