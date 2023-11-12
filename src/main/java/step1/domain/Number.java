package step1.domain;

public class Number {

    private int value;

    public Number(String value) {
        this.value = Integer.parseInt(value);
    }

    public int value() {
        return value;
    }

}
