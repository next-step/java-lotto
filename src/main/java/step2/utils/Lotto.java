package step2.utils;

import java.util.List;
import java.util.Objects;

public class Lotto {
    List<Integer> lottoNumber;

    public Lotto() {
        this.lottoNumber = RandomIntegerGenerator.getRandomInteger();
    }

    public Lotto(List<Integer> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public List<Integer> getLotto() {
        return this.lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumber, lotto.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
