package calculator;

public class Number {

    private final int number;

    public Number(String number) {
        this.number = Integer.parseInt(number);

        checkNegativeNumber(this.number);
    }

    private void checkNegativeNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 계산할 수 없다.");
        }
    }

    public int number() {
        return number;
    }

}
