package caculator;

public class Number {

    private int value;

    public Number(String value) {
        this.value = Integer.parseInt(value);
    }
    public Number(int value) {
        this.value = value;
    }

    public void plus(Number number) {
        this.value += number.value;
    }

    public void minus(Number number) {
        this.value -= number.value;
    }

    public void multiple(Number number) {
        this.value *= number.value;
    }

    public void divide(Number number) {
        this.value /= number.value;
    }

    @Override
    public String toString() {
        return "Number value is : " + value;
    }
}

