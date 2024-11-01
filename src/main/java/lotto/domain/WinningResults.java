package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningResults {
    private Map<LottoRank, Integer> results = new HashMap<>();

    public WinningResults(LottoManager lottoManager, Lotto winningLotto) {
        init();
        calculateResults(lottoManager, winningLotto);
    }

    private void init() {
        for (LottoRank prize : LottoRank.values()) {
            results.put(prize, 0);
        }
    }

    private void calculateResults(LottoManager lottoManager, Lotto winningLotto) {

        lottoManager.purchasedLottos()
                .stream()
                .map(v -> v.countMatchingNumbers(winningLotto))
                .forEach(this::updateResults);
    }

    private void updateResults(LottoRank lottoRank) {
        if (lottoRank == null) {
            return;
        }

        if (results.containsKey(lottoRank)) {
            results.put(lottoRank, results.get(lottoRank) + 1);
        }
    }

    public Map<LottoRank, Integer> getResults() {
        return results;
    }

}
