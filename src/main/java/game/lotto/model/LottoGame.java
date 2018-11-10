package game.lotto.model;

import game.lotto.util.LottoMatcher;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class LottoGame {

    private Amount amount;
    private LottoRegistry lottoRegistry;

    public LottoGame(Money money) {
        this.amount = new Amount(money);
        initLottoRegistry(LottosFactory.createLottos(amount));
    }

    public LottoGame(Collection<Lotto> lottos) {
        initLottoRegistry(lottos);
    }

    private void initLottoRegistry(Collection<Lotto> lottos) {
        this.lottoRegistry = new LottoRegistry(lottos);
    }

    public Amount getAmount() {
        return new Amount(amount);
    }

    public List<Lotto> getLottos() {
        return this.lottoRegistry.getLottos();
    }

    public MatchResult match(Set<LottoNumber> winningNumbers) {

        return LottoMatcher.match(winningNumbers, lottoRegistry.getLottos());
    }
}
