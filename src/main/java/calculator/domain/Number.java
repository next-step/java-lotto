package calculator.domain;

public class Number {

    private int value;

    public Number(String value) {
        this.value = Integer.parseInt(value);
    }

    public Number(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

}
