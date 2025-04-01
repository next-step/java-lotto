package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoNumberMatcher {

    private List<LottoNumbers> lottoNumbers;
    private WinningLottoNumbers winningLottoNumbers;

    public LottoNumberMatcher(List<LottoNumbers> lottoNumbers, WinningLottoNumbers winningLottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        this.winningLottoNumbers = winningLottoNumbers;
    }

    public LottoWinningRecord result() {
        Map<LottoRank, Integer> lottoWinningBoardMap = initializeLottoWinningBoardMap();
        calculateMatchStats(lottoWinningBoardMap);

        return new LottoWinningRecord(lottoWinningBoardMap);
    }

    private void calculateMatchStats(Map<LottoRank, Integer> rank) {
        lottoNumbers.forEach(lottoNumber -> {
            LottoRank lottoRank = winningLottoNumbers.lottoRank(lottoNumber);
            rank.put(lottoRank, rank.get(lottoRank) + 1);
        });
    }

    private static Map<LottoRank, Integer> initializeLottoWinningBoardMap() {
        Map<LottoRank, Integer> rankMap = new EnumMap<>(LottoRank.class);
        for(LottoRank lottoRank: LottoRank.values()) {
            rankMap.put(lottoRank, 0);
        }
        return rankMap;
    }
}
