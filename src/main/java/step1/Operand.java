package step1;

public class Operand {
    private final int value;

    public Operand(String value) {
        try {
            this.value = Integer.parseInt(value);
            if (this.value < 0) {
                throw new IllegalArgumentException("음수 값이 입력되었습니다. 값 : " + value);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다. 값 : " + value);
        }
    }

    public boolean isSameValue(int number) {
        return value == number;
    }
    public int getValue() {
        return value;
    }
}
