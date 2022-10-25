package lotto.domain;

import java.util.List;

public class Lotto {

    private final LottoResult lottoResult;

    public Lotto(List<Integer> lottoNumberList) {
        this(new LottoResult(lottoNumberList));
    }

    public Lotto(LottoResult lottoResult) {
        this.lottoResult = lottoResult;
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoResult.getLottoNumbers();
    }

    public Rank rank(LottoResult winnerLottoResult) {
        return lottoResult.getMatchCount(winnerLottoResult);
    }

}
