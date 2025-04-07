package lotto.domain;

import java.util.List;
import java.util.Map;

public class LottoWinningRecord {

    Map<LottoRank, Integer> lottoRankMap;

    public LottoWinningRecord() {
        lottoRankMap = LottoRank.createLottoWinningBoardMap();
    }

    public float totalLottoPrizeAmount() {
        long total = lottoRankMap.keySet()
                .stream()
                .mapToLong( key -> {
                    int count = lottoRankMap.get(key);
                    return key.money() * count;
                })
                .sum();
        return total;
    }

    public Map<LottoRank, Integer> lottoRankMap() {
        return lottoRankMap;
    }

    public LottoWinningRecord match(WinningLottoNumbers winningLottoNumbers, Lottos lottoNumbers) {
        calculateMatchStats(lottoRankMap, winningLottoNumbers, lottoNumbers.lottoNumbers());
        return this;
    }

    private void calculateMatchStats(Map<LottoRank, Integer> rank, WinningLottoNumbers winningLottoNumbers, List<LottoNumbers> lottoNumbers) {
        lottoNumbers.forEach(lottoNumber -> {
            LottoRank lottoRank = winningLottoNumbers.lottoRank(lottoNumber);
            rank.merge(lottoRank, 1, Integer::sum);
        });
    }
}
