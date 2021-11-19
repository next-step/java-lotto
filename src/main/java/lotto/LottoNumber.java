package lotto;

import java.util.Objects;

/**
 * LottoNumber 는 일반 번호 하나와 자신이 보너스 번호인지 구분할 상태를 가지고 있다.
 */
public class LottoNumber implements Comparable<LottoNumber> {
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 45;

    private final int number;

    /**
     * String 값을 Integer 로 파싱하여 default 생성자로 위임한다.
     * @param number
     */
    public LottoNumber(String number) {
        this(Integer.parseInt(number));
    }

    /**
     * @DEFAULT_CONSTRUCTOR
     * 해당 integer 값을 번호로하고 해당 boolean 값을 보너스 상태로 하는 객체를 생성한다.
     * @param number
     */
    public LottoNumber(int number) {
        validateNumberRange(number);

        this.number = number;
    }

    /**
     * int 값이 LOWER_BOUND 에서 UPPER_BOUND 사이의 값이 아니면 예외를 던진다.
     * @param number
     */
    private void validateNumberRange(int number) {
        if (number < LOWER_BOUND || number > UPPER_BOUND) {
            throw new IllegalArgumentException("로또 번호는 1에서 45사이의 값이어야 합니다.");
        }
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
    public int compareTo(LottoNumber other) {
        return this.number - other.number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
