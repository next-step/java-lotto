package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private static final int LOTTO_MIN_VALUE = 1;
    private static final int LOTTO_MAX_VALUE = 45;

    private static class LottoNumCache {
        private static LottoNumber[] cache = new LottoNumber[LOTTO_MAX_VALUE];
        static{
            for (int i = 0; i < LOTTO_MAX_VALUE; i++){
                cache[i] = new LottoNumber(i + 1);
            }
        }
        private LottoNumCache() {}
    }

    public static LottoNumber valueOf(String number){
        return valueOf(Integer.parseInt(number));
    }

    public static LottoNumber valueOf(int number) {
        if (number >= LOTTO_MIN_VALUE && number <= LOTTO_MAX_VALUE){
            return LottoNumCache.cache[number - 1];
        }
        return new LottoNumber(number);
    }

    private final int number;

    private LottoNumber(final String number) {
        this(Integer.parseInt(number));
    }

    private LottoNumber(final int number) {
        if(number < LOTTO_MIN_VALUE || number > LOTTO_MAX_VALUE){
            throw new IllegalArgumentException("로또 숫자는 1이상 45이하 범위 이내에서 입력하세요");
        }
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
        return Objects.hashCode(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
