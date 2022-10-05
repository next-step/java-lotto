package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    public static final Integer MIN = 1;
    public static final Integer MAX = 45;

    private final Integer number;

    public LottoNumber(Integer number) {
        validateNumber(number);

        this.number = number;
    }

    public static LottoNumber of(Integer number) {
        return new LottoNumber(number);
    }

    public Integer number() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    private void validateNumber(Integer number) {
        if (number < MIN || number > MAX) {
            String message = "로또 숫자는 %s이상 %s이하 정수여야 합니다.";
            throw new IllegalArgumentException(String.format(message, MIN, MAX));
        }
    }
}
