package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoWinningChecker {
    private final Map<Integer, Integer> ranks = new HashMap<>();

    public LottoWinningChecker(List<Lotto> lottos, Lotto winLotto) {
        for (Lotto lotto : lottos) {
            int matchCount = getMatchCount(winLotto.getLottoNumbers(), lotto.getLottoNumbers());
            ranks.put(matchCount, ranks.getOrDefault(matchCount, 0) + 1);
        }
        LottoProfit.calculate(ranks, lottos.size());
    }

    private int getMatchCount(List<LottoNumber> lottoNumbers, List<LottoNumber> winNumbers) {
        int count = 0;

        for (LottoNumber winNumber : winNumbers) {
            count += isNumberPresent(lottoNumbers, winNumber);
        }

        return count;
    }

    private int isNumberPresent(List<LottoNumber> lottoNumbers, LottoNumber winNumber) {
        if (lottoNumbers.contains(winNumber)) {
            return 1;
        }
        return 0;
    }

    public Map<Integer, Integer> getRanks() {
        return ranks;
    }
}
