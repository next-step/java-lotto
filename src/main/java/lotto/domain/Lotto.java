package lotto.domain;

import java.util.List;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto() {
        this(new LottoNumbers());
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
