package lottoauto.model;

import java.util.Objects;

public class LottoNumber implements Comparable {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private final int number;

    public LottoNumber(int number) {
        this.number = numberValidation(number);
    }

    public static LottoNumber from(int number) {
        return new LottoNumber(number);
    }

    public int getNumber() {
        return this.number;
    }

    private int numberValidation(int number) {
        if (isInvalidNumber(number)) {
            throw new IllegalArgumentException("로또 숫자는 1에서 45사이의 숫자여야 합니다.");
        }

        return number;
    }

    private boolean isInvalidNumber(int number) {
        return number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

}
