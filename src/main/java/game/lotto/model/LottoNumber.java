package game.lotto.model;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int MIN = 1;
    public static final int MAX = 45;

    private final int value;

    public LottoNumber(int number) {
        if(isRange(number)) {
            throw new IllegalArgumentException("숫자는 1 ~ 45 범위여야 합니다.");
        }

        this.value = number;
    }

    private boolean isRange(int number) {
        return number < MIN || number > MAX;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoNumber that = (LottoNumber) o;

        return value == that.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public int compareTo(LottoNumber other) {

        return Integer.compare(this.value, other.value);
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
