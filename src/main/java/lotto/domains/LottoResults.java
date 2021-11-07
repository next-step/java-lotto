package lotto.domains;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResults {

    private final List<LottoResult> lottoResults;

    public LottoResults() {
        Map<Integer, Integer> winningInfos = new HashMap<>();
        winningInfos.put(3, 5000);
        winningInfos.put(4, 50000);
        winningInfos.put(5, 1500000);
        winningInfos.put(6, 2000000000);

        List<LottoResult> lottoResults = new ArrayList<>();
        for (Integer key : winningInfos.keySet()) {
            lottoResults.add(new LottoResult(key, winningInfos.get(key)));
        }

        this.lottoResults = lottoResults;
    }

    public void addWinner(int matchCnt) {
        for (LottoResult lottoResult : lottoResults) {
            if (lottoResult.match(matchCnt)) {
                lottoResult.addWinner();
            }
        }
    }

    public List<LottoResult> getLottoResults() {
        return this.lottoResults;
    }

    public Double profitRate(int money) {
        Double totalPrize = 0.0;

        for (LottoResult lottoResult : lottoResults) {
            totalPrize += lottoResult.totalPrizeAmount();
        }

        return totalPrize / money ;
    }
}
