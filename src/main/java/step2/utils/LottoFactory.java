package step2.utils;

import java.util.List;
import java.util.Objects;

public class LottoFactory {
    List<Integer> lottoNumber;

    public LottoFactory() {
        this.lottoNumber = RandomIntegerGenerator.getRandomInteger();
    }

    public LottoFactory(List<Integer> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoFactory that = (LottoFactory) o;
        return Objects.equals(lottoNumber, that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
