package calculator;

public class Number {

    private final int num;

    public Number(String numString) {
        this.num = parseInt(numString);
    }

    int parseInt(String numString) {
        return Integer.parseInt(numString);
    }

    public int intValue() {
        return num;
    }
}
