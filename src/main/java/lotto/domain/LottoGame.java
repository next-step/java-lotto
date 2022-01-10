package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.utils.NumberStrategy;
import lotto.utils.RandomNumberStrategy;

public class LottoGame {

    private static final NumberStrategy numberStrategy = new RandomNumberStrategy();

    private List<Lotto> lottos = new ArrayList<>();

    private LottoCount lottoCount;

    public LottoGame(int totalCount, ManualLottos manualLottos) {
        lottos.addAll(manualLottos.getManualLottos());
        this.lottoCount = new LottoCount(totalCount, manualLottos.getManualLottos().size());
        addRandomLotto();
    }

    public LottoGame(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private void addRandomLotto() {
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

    public LottoResult draw(WinningLotto winningLotto) {
        return winningLotto.lottoResult(this.lottos);
    }

}
