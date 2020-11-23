package lotto.domain;

public class RankedLotto {

    private LottoRanking ranking;
    private Lotto lotto;

    public RankedLotto(LottoRanking ranking, Lotto lotto) {
        this.ranking = ranking;
        this.lotto = lotto;
    }

    public LottoRanking getRanking() {
        return ranking;
    }

}
