package lotto.domain;

public class Number implements Comparable<Number> {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final int number;


    public Number(int number) {
        checkValidNumber(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(Number number) {
        return getNumber() - number.getNumber();
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }


    private void checkValidNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("1 ~ 45 사이 숫자만 입력 가능합니다.");
        }
    }
}
