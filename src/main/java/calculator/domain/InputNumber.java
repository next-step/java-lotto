package calculator.domain;

public class InputNumber {

    private int number;

    private InputNumber(int number) {
        this.number = number;
    }

    public static InputNumber createZeroNumber() {
        return new InputNumber(0);
    }

    public static InputNumber createPositiveNumber(int number) {

        if (number < 0) {
            throw new RuntimeException("입력값은 음수는 불가능합니다.");
        }

        return new InputNumber(number);
    }

    public void add(InputNumber number) {
        this.number += number.getNumber();
    }

    public int getNumber() {
        return number;
    }
}
