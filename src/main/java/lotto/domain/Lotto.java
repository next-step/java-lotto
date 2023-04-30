package lotto.domain;

import java.util.List;

public class Lotto {

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

    public int getLottoSize(){
        return lottoNumberGroup.getLottoNumberGroupSize();
    }

    public Money getLottoFee() {
        return Money.wons(1000);
    }
}
