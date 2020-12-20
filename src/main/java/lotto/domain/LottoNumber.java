package lotto.domain;

public class LottoNumber {
    private static final int MINIMUM_VALUE = 1;
    private static final int MAXIMUM_VALUE = 45;

    private final int number;

    public LottoNumber(int number) {
        if (number < MINIMUM_VALUE || number > MAXIMUM_VALUE) {
            throw new IllegalArgumentException("1 - 45 사이 숫자를 입력해주세요.");
        }
        this.number = number;
    }

    public static LottoNumber of(String number) {
        try {
            return new LottoNumber(Integer.parseInt(number));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해 주세요.");
        }
    }

    public int isGreaterThan(LottoNumber operand) {
        return this.number - operand.number;
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

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
