package domain.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static domain.constant.LottoConstants.MATCH_PRICES;

public class LottoWallet {
    private final List<LottoNumbers> lottos = new ArrayList<>();

    public void addLottos(List<LottoNumbers> lottos) {
        this.lottos.addAll(lottos);
    }

    public void countMatches(LottoNumbers winNumbers) {
        for (LottoNumbers lotto : lottos) {
            lotto.countMatch(winNumbers);
        }
    }

    public Map<Integer, Integer> getMatchResult() {
        Map<Integer, Integer> matchResult = new HashMap<>();
        for (LottoNumbers lotto : lottos) {
            int matchCount = lotto.getMatchCount();
            if (MATCH_PRICES.containsKey(matchCount)) {
                matchResult.put(matchCount, matchResult.getOrDefault(matchCount, 0) + 1);
            }
        }
        return matchResult;
    }

    public int getPrize() {
        int totalPrize = 0;
        for (LottoNumbers lotto : lottos) {
            int matchCount = lotto.getMatchCount();
            totalPrize += MATCH_PRICES.get(matchCount);
        }
        return totalPrize;
    }


    public List<LottoNumbers> getLottos() {
        return this.lottos;
    }
}
