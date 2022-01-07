package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import lotto.utils.FixNumberStrategy;
import lotto.utils.NumberStrategy;
import lotto.utils.RandomNumberStrategy;

public class LottoGame {

    private static final NumberStrategy numberStrategy = new RandomNumberStrategy();

    private List<Lotto> lottos = new ArrayList<>();

    private LottoCount lottoCount;

    public LottoGame(int totalCount, int manualCount) {
        this.lottoCount = new LottoCount(totalCount, manualCount);
    }

    public LottoGame(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void addManualLotto(Set<Integer> manualNumber) {
        NumberStrategy numberStrategy = new FixNumberStrategy(new ArrayList<>(manualNumber));
        lottos.add(new Lotto(numberStrategy));
    }

    public void addRandomLotto() {
        for (int i = 0; i < lottoCount.getAutoCount(); i++) {
            lottos.add(new Lotto(numberStrategy));
        }
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public LottoCount getLottoCount() {
        return lottoCount;
    }

    public LottoResult draw(Set<Integer> winningNumber, int bonusBall) {
        NumberStrategy numberStrategy = new FixNumberStrategy(new ArrayList<>(winningNumber));
        WinningLotto winningLotto = new WinningLotto(numberStrategy, bonusBall);
        return winningLotto.lottoResult(this.lottos);
    }

}
