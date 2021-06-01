package lotto.model;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{
    private final int MIN_LOTTO_NUM = 1;
    private final int MAX_LOTTO_NUM = 45;
    private final String OUT_OF_NUMER_RANGE_MESSAGE = "out of number range";
    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        this.lottoNumber = validate(lottoNumber);
    }

    private int validate(int number){
        if(number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM){
            throw new RuntimeException(OUT_OF_NUMER_RANGE_MESSAGE);
        }
        return number;
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

    public int number() {
        return lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber that){
        if (this.lottoNumber > that.lottoNumber){
            return 1;
        }
        if(this.lottoNumber < that.lottoNumber){
            return -1;
        }
        return 0;
    }
}
