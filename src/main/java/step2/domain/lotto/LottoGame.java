package step2.domain.lotto;

import step2.domain.statistics.Statistics;

public class LottoGame {
    private final Lottos lottos;
    private final WinningLotto winningLotto;

    public LottoGame(Lottos lottos, WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
    }

    public Statistics start() {
        return winningLotto.match(lottos);
    }
}
