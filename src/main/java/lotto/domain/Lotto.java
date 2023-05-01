package lotto.domain;

import java.util.List;

public class Lotto {
    public static final Integer LOTTO_UNIT_PRICE = 1000;
    private static final Money lOTTO_FEE = Money.wons(LOTTO_UNIT_PRICE);

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto from(LottoNumbers lottoNumbers) {
        return new Lotto(lottoNumbers.aggregateNonDuplicateLottoNumber());
    }

    public static Lotto of(LottoNumbers lottoNumbers, List<Integer> lottoNumberList) {
        return new Lotto(lottoNumbers.initializedManualLottoNumber(lottoNumberList));
    }

    public int countMatching(LottoNumbers winnerLottoGroup) {
        return lottoNumbers.countMatchingLottoNumber(winnerLottoGroup);
    }

    public int getLottoSize() {
        return lottoNumbers.getLottoNumberGroupSize();
    }

    public static Money getLottoFee() {
        return lOTTO_FEE;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
