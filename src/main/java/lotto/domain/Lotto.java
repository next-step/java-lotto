package lotto.domain;

import java.util.List;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(List<Integer> lottoNumberList) {
        this(new LottoNumbers(lottoNumberList));
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers.getLottoNumberList();
    }

    public Rank rank(LottoNumbers winnerLottoNumbers) {
        return lottoNumbers.getMatchCount(winnerLottoNumbers);
    }

}
