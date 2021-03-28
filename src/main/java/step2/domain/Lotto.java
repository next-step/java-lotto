package step2.domain;

import java.util.Collections;
import java.util.Set;

public class Lotto {

    public static final int NUMBER_SIZE = 6;

    private final LottoNumber lottoNumbers;

    public Lotto(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumbers = new LottoNumber(lottoNumberGenerator.getGeneratedNumbers());
    }


    public LottoNumber getLottoNumber() {
        return this.lottoNumbers;
    }

    public int matchNumberCounts(Lotto lotto) {
        return this.lottoNumbers.getMatchCount(lotto.getLottoNumber());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
