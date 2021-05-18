package calculator.domain;

public class InputNumber {

    private int number;

    public InputNumber(int number) {
        this.number = number;

        if (number < 0) {
            throw new RuntimeException("입력값은 음수는 불가능합니다.");
        }
    }

    public static InputNumber create(int value) {
        return new InputNumber(value);
    }

    public void add(InputNumber number) {
        this.number += number.getNumber();
    }

    public int getNumber() {
        return number;
    }
}
