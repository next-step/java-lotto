package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    public static final int MAX_NUMBER = 45;
    public static final int MIN_NUMBER = 1;
    private final int lottoNumber;

    public LottoNumber(int number) {
        this.lottoNumber = validate(number);
    }

    private int validate(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1-45 사이어야 합니다.");
        }
        return number;
    }
    public static LottoNumber valueOf(int number){
        if(number>=MIN_NUMBER && number<=MAX_NUMBER){
            return LottoNumberCache.findNumber(number);
        }
        return new LottoNumber(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}

