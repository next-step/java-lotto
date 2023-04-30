package lotto.domain;

import java.util.List;

public class Lotto {
    public static final Integer LOTTO_UNIT_PRICE = 1000;
    private static final Money lOTTO_FEE = Money.wons(LOTTO_UNIT_PRICE);

    private final LottoNumberGroup lottoNumberGroup;

    public Lotto(LottoNumberGroup lottoNumberGroup) {
        this.lottoNumberGroup = lottoNumberGroup;
    }

    public static Lotto from(LottoNumberGroup lottoNumberGroup) {
        return new Lotto(lottoNumberGroup.aggregateNonDuplicateLottoNumber());
    }

    public static Lotto of(LottoNumberGroup lottoNumberGroup, List<Integer> lottoNumberList) {
        return new Lotto(lottoNumberGroup.initializedManualLottoNumber(lottoNumberList));
    }

    public int countMatching(LottoNumberGroup winnerLottoGroup) {
        return lottoNumberGroup.countMatchingLottoNumber(winnerLottoGroup);
    }

    public int getLottoSize() {
        return lottoNumberGroup.getLottoNumberGroupSize();
    }

    public static Money getLottoFee() {
        return lOTTO_FEE;
    }

    @Override
    public String toString() {
        return lottoNumberGroup.toString();
    }
}
