package lotto.domain;

import java.util.Set;

public class PrizeLotto  {

    private LottoNumbers prizeNumbers;

    public PrizeLotto(LottoNumbers prizeNumbers) {
        this.prizeNumbers = prizeNumbers;
    }

    public boolean findByIndexNumber(int lottoNumber) {
        return prizeNumbers.getLottoNumbers()
                            .contains(lottoNumber);
    }

    public Set<Integer> getPrizeNumbers() {
        return prizeNumbers.getLottoNumbers();
    }
}