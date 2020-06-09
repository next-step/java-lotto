package lotto.domain.lotto;

import java.util.List;

public class LottoNumber implements Comparable<LottoNumber> {
    int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber create(int lottoNumber) {
        return new LottoNumber(lottoNumber);
    }


    public boolean isContains(List<Integer> Numbers) {
        return Numbers.contains(lottoNumber);
    }

    public boolean isExist(int number) {
        return lottoNumber == number;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

    @Override
    public int compareTo(LottoNumber out) {
        if (this.lottoNumber > out.lottoNumber)
            return 1;
        if (this.lottoNumber < out.lottoNumber)
            return -1;
        return 0;
    }


}
