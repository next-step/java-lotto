package game.lotto.model;

import java.util.Collections;
import java.util.Set;

public class Lotto {

    public static final int NUMBER_SIZE = 6;

    private Set<LottoNumber> lottoNumbers;

    public Lotto() {
        this.lottoNumbers = LottoNumberFactory.createRandomLottoNumbers();
    }


    public Set<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }
}
