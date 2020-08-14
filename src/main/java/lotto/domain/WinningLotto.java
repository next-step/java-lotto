package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusBall;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusBall) {
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    public LottoResult match(Lottos lottos) {
        LottoResult lottoResult = new LottoResult(lottos.getTotalPrice());
        List<LottoRanking> rankings = lottos.matchWinningLotto(this);
        for (LottoRanking ranking : rankings) {
            lottoResult.addRanking(ranking);
        }
        return lottoResult;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }
}
