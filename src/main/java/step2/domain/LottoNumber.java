package step2.domain;

import java.util.Objects;

/**
 * 로또 번호
 */
public class LottoNumber {
    public static final int MAX_NUMBER = 45;
    public static final int MIN_NUMBER = 1;

    private final int number;

    /**
     * 생성자를 통해 초기화를 한다.
     * 1보다 작은 값은 사용할 수 없다.
     *
     * @param number
     */
    public LottoNumber(final int number) {
        if (number < MIN_NUMBER)
            throw new IllegalArgumentException(String.format("번호는 %s보다 작은 값을 입력할 수 없습니다.", MIN_NUMBER));

        if (number > MAX_NUMBER)
            throw new IllegalArgumentException(String.format("번호는 %s보다 큰 값을 입력할 수 없습니다.", MAX_NUMBER));

        this.number = number;
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
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
