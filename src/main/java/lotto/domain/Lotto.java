package lotto.domain;

import java.util.List;

public class Lotto {

    private final LottoNumbers lottoNumbers;
    private Rank rank;

    public Lotto() {
        this(new LottoNumbers());
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers.getLottoNumberList();
    }

    public Rank getRank() {
        return this.rank;
    }

    public Lotto rank(LottoNumbers winnerLottoNumbers) {
        this.rank = lottoNumbers.getMatchCount(winnerLottoNumbers);
        return this;
    }

}
