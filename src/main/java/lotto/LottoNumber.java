package lotto;

import java.security.InvalidParameterException;
import java.util.Objects;
import java.util.Random;

public final class LottoNumber implements Comparable<LottoNumber> {

    public static final int MAX = 44;
    public static final int MIN = 1;
    private final int number;

    public LottoNumber() {
        Random random = new Random();
        this.number = random.nextInt(MAX) + 1;
    }

    public LottoNumber(int number) {
        if(number > MAX || number < MIN){
            throw new InvalidParameterException("로또 번호는 1과 45 사이 숫자만 가능합니다");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.number, other.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
