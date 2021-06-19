package lottoAuto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();
    private LottoGenerator lottoGenerator;

    public Lottos(int amount) {
        lottoGenerator = new LottoGenerator();
        for (int i = 0; i < amount; i++) {
            lottos.add(lottoGenerator.createLotto());
        }
    }

    public LottoResults matchWinningLotto(WinningLotto winningLotto) {
        LottoResults lottoResults = new LottoResults();
        lottos.stream()
                .map(lotto -> new LottoResult(lotto.countWinningLottoNumbers(winningLotto.getWinningLotto())))
                .forEach(lottoResults::add);
        return lottoResults;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
