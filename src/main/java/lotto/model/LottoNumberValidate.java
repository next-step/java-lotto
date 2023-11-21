package lotto.model;

import java.util.Objects;

public class LottoNumberValidate implements Comparable<LottoNumberValidate>{
    public static final int LOTTO_MIN_RANGE = 1;
    public static final int LOTTO_MAX_RANGE = 45;
    private final int number;

    public LottoNumberValidate(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    public int number() {
        return this.number;
    }

    private static void validateNumberRange(int number) {
        if (number < LOTTO_MIN_RANGE || number > LOTTO_MAX_RANGE) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이여야 합니다. 입력하신 번호는 " + number + "입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumberValidate number1 = (LottoNumberValidate) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumberValidate o) {
        return this.number - o.number;
    }

}
