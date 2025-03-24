package calculator.domain;

public class Operand {
    private final Integer value;

    public Operand(String input) {
        try {
            this.value = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("피연산자로 정수만 입력 가능합니다. 현재 입력값: " + input);
        }
    }

    public Operand(Integer input) {
        this.value = input;
    }

    public Integer getValue() {
        return value;
    }
}
