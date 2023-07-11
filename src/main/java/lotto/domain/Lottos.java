package lotto.domain;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public long size() {
        return lottos.size();
    }

    public LottoResults matchWinningNumbers(WinningNumbers winningNumbers) {
        LottoResults lottoResults = new LottoResults();
        for (Lotto lotto : lottos) {
            lottoResults.add(winningNumbers.match(lotto), 1);
        }
        return lottoResults;
    }
}
