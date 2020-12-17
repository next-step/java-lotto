package calculator;

public class PositiveNumber {
    private int num;

    public PositiveNumber(int num) {
        if (num < 0) {
            throw new IllegalArgumentException();
        }
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
