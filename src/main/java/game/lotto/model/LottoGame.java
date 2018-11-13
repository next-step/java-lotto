package game.lotto.model;

import game.lotto.util.LottoMatcher;

import java.util.Collection;
import java.util.List;

public class LottoGame {

    private Amount amount;
    private LottoRegistry lottoRegistry;

    public LottoGame(LottosGenerator generator) {
        this.lottoRegistry = new LottoRegistry(generator.generate());
        this.amount = this.lottoRegistry.getAmount();
    }

    public LottoGame(Collection<Lotto> lottos) {
        initLottoRegistry(lottos);
    }

    private void initLottoRegistry(Collection<Lotto> lottos) {
        this.lottoRegistry = new LottoRegistry(lottos);
    }

    public Amount getAmount() {
        return new Amount(this.amount);
    }

    public List<Lotto> getLottos() {
        return this.lottoRegistry.getLottos();
    }

    public MatchResult match(WinningLotto winningLotto) {

        return LottoMatcher.match(winningLotto, lottoRegistry.getLottos());
    }
}
