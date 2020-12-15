package stringcalculator.domain;

public class Sum {
    private static final int LESS_THAN = 0;

    private int sum;

    public Sum(int sum) {
        this.sum = sum;
    }

    public void add(int number) {
        checkNumber(number);
        this.sum += number;
    }

    public int getSum() {
        return this.sum;
    }

    private void checkNumber(int number) {
        if(number < LESS_THAN) {
            throw new RuntimeException("0 이하 숫자는 입력할 수 없습니다.");
        }
    }
}
