package lotto.domain;

import java.util.List;

public class LottoGame {

    private final Lottos lottos;

    public LottoGame(Lottos lottos) {
        this.lottos = lottos;
    }

    public List<List<Integer>> lottos() {
        return lottos.result();
    }

    public LottoScore score(WinningNumbers winningNumbers) {
        List<LottoMatcher> lottoMatchers = lottos.matchResult(winningNumbers);
        return new LottoScore(lottoMatchers);
    }

    public int quantity() {
        return lottos.quantity();
    }

    public void buyLotto(int price) {
        lottos.buyLotto(price);
    }
}
