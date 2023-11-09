public class Calculator {
    private int result;

    public Calculator(int num) {
        this.result += num;
    }

    public int getResult() {
        return result;
    }

    public void plus(int num) {
        result += num;
    }

    public void minus(int num) {
        result -= num;
    }

    public void multiply(int num) {
        result *= num;
    }

    public void divide(int num) {
        result /= num;
    }

    public void clear() {
        result = 0;
    }
}
