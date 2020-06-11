package study.lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Map<LottoRank, Integer> rankToCount;

    private LottoResult(Lottos lottos, WinningLottoInfo winningLottoInfo) {
        rankToCount = countingByLottoRank(lottos, winningLottoInfo);
    }

    public static LottoResult produce(Lottos lottos, WinningLottoInfo winningLottoInfo) {
        return new LottoResult(lottos, winningLottoInfo);
    }

    private Map<LottoRank, Integer> countingByLottoRank(Lottos lottos, WinningLottoInfo winningLottoInfo) {
        Map<LottoRank, Integer> rankToCount = new HashMap<>();

        lottos.getLottos()
            .forEach(lotto -> {
                LottoRank lottoRank = winningLottoInfo.checkLottoRank(lotto);
                rankToCount.put(lottoRank, rankToCount.getOrDefault(lottoRank, 0) + 1);
            });

        return rankToCount;
    }

    public Map<LottoRank, Integer> getRankToCount() {
        return rankToCount;
    }
}
