package domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final String MESSAGE_LOTTO_NUMBER_RANGE_OVER = "(ERROR) 로또 숫자의 범위를 벗어났습니다.";
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    private final int number;

    public LottoNumber(int number) {
        verifyRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void verify(LottoNumber o) {
        verifyRange(o.number);
    }

    private void verifyRange(int number) {
        if (number < START_NUMBER || number > END_NUMBER) {
            throw new IllegalArgumentException(MESSAGE_LOTTO_NUMBER_RANGE_OVER);
        }
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return getNumber() == that.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}
