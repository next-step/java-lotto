package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoWinningChecker {
    private final Map<LottoPrize, Integer> ranks = new HashMap<>();
    private final LottoProfit lottoProfit;

    public LottoWinningChecker(List<Lotto> lottos, Lotto winLotto, LottoNumber bonusNumber) {
        for (Lotto lotto : lottos) {
            int matchCount = getMatchCount(lotto.getLottoNumbers(), winLotto.getLottoNumbers());
            boolean isMatchBonus = isNumberPresent(lotto.getLottoNumbers(), bonusNumber);
            LottoPrize lottoPrize = LottoPrize.valueOf(matchCount, isMatchBonus);
            ranks.put(lottoPrize, ranks.getOrDefault(lottoPrize, 0) + 1);
        }
        lottoProfit = new LottoProfit(ranks, lottos.size());
    }

    private int getMatchCount(List<LottoNumber> lottoNumbers, List<LottoNumber> winNumbers) {
        int count = 0;

        for (LottoNumber winNumber : winNumbers) {
            count += isNumberPresent(lottoNumbers, winNumber) ? 1 : 0;
        }

        return count;
    }

    private boolean isNumberPresent(List<LottoNumber> lottoNumbers, LottoNumber winNumber) {
        if (lottoNumbers.contains(winNumber)) {
            return true;
        }
        return false;
    }

    public Map<LottoPrize, Integer> getRanks() {
        return ranks;
    }

    public Double getProfitRate() {
        return lottoProfit.getProfitRate();
    }
}
