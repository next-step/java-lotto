package lotto.domain;

import java.util.List;

public class LottoGame {

    private final Lotto lotto;

    public LottoGame(final int price, final LottoNumberSelectPolicy lottoNumberSelectPolicy) {
        this.lotto = new Lotto(price, lottoNumberSelectPolicy);
    }

    public int size() {
        return lotto.size();
    }

    public Lotto getLotto() {
        return lotto;
    }

    public List<LottoRank> checkResult(final LottoNumbers winningNumbers) {
        return lotto.getLottoRanks(winningNumbers);
    }

}
