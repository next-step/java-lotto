public class Number {
    private int number;

    public Number(int number) {
        this.number = number;
    }

    public static Number ofNumber(String input) {
        try {
            return new Number(Integer.parseInt(input));
        } catch (Exception e) {
            throw new NumberFormatException("숫자가 아닙니다.");
        }
    }

    public void add(Number inputNum) {
        this.number += inputNum.number;
    }

    public void subtract(Number fromQueue) {
        this.number -= fromQueue.number;
    }

    public void multiple(Number inputNum) {
        this.number *= inputNum.number;
    }

    public void divide(Number inputNum) {
        this.number /= inputNum.number;
    }

    public int getAnswer() {
        return number;
    }

}
