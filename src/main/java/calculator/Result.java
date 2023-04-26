package calculator;

public class Result {

    private int number;

    public Result(int number) {
        this.number = number;
    }

    public int get() {
        return number;
    }

    public void apply(Operations operation, int nextNum) {
        number = operation.apply(number, nextNum);
    }
}
