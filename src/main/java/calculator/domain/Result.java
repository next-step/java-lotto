package calculator.domain;

public class Result {

    private int value;

    public Result(int value) {
        this.value = value;
    }

    public void add(int operand) {
        this.value += operand;
    }

    public void subtract(int operand) {
        this.value -= operand;
    }

    public void multiply(int operand) {
        this.value *= operand;
    }

    public void divide(int operand) {
        this.value /= operand;
    }

    public int get() {
        return this.value;
    }
}
