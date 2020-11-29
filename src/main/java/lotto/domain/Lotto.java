package lotto.domain;

import java.util.Set;

public class Lotto {

    private LottoNumber lottoNumbers;

    public Lotto(Set<Integer> lottoNumber) {
        this.lottoNumbers = LottoNumber.from(lottoNumber);
    }

    public PrizeInformation matchPrizeNumber(PrizeLotto prizeLotto) {
        return lottoNumbers.matchPrizeNumber(prizeLotto);
    }

    public Set<Integer> getLottoNumbers() {
        return lottoNumbers.getLottoNumber();
    }

    public int sizeLottoNumber() {
        return lottoNumbers.size();
    }
}