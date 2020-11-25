package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    public LottoNumber(String number) {
        try {
            this.number = Integer.parseInt(number.trim());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
//        System.out.println(number + " , " + that.number);
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
