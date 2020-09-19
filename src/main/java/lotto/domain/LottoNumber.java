package lotto.domain;

import java.util.*;

public class LottoNumber implements Comparable<LottoNumber>{
    private static final Map<Integer, LottoNumber> LOTTO_NUMBERS = new HashMap<>();
    static{
        for(int i = Lotto.LOTTO_START_NUM ; i <= Lotto.LOTTO_END_NUM ; i ++ ){
            LOTTO_NUMBERS.put(i, new LottoNumber(i));
        }
    }

    private final int number;

    private LottoNumber(int number) {
        if(number < Lotto.LOTTO_START_NUM || number > Lotto.LOTTO_END_NUM) {
            throw new IllegalArgumentException("LottoNumber is out of range[0-45]");
        }
        this.number = number;
    }

    public static LottoNumber of(int num){
        return Optional.ofNullable(LOTTO_NUMBERS.get(num))
                .orElseThrow(() -> new IllegalArgumentException("LottoNumber is out of range[0-45]"));
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
        return Integer.toString(number);
    }

    public int getNumber(){
        return this.number;
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        LottoNumber compare = lottoNumber;
        return number - compare.number;
    }
}
