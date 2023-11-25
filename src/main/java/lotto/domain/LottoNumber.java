package lotto.domain;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final int number;

    public LottoNumber(int input) {
        validateNumber(input);
        this.number = input;
    }

    private void validateNumber(int input) {
        if (input < MIN_NUMBER || input > MAX_NUMBER) {
            throw new IllegalArgumentException(String.format("%d부터 %d사이의 숫자여야합니다 : %d", MIN_NUMBER, MAX_NUMBER, input));
        }
    }

    @Override
    public int compareTo(LottoNumber target) {
        return Integer.compare(this.number, target.number);
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoNumber that = (LottoNumber) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
