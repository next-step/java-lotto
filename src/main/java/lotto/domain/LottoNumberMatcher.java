package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoNumberMatcher {

    private List<LottoNumber> lottoNumbers;
    private LottoNumber winningLottoNumbers;

    public LottoNumberMatcher(List<LottoNumber> lottoNumbers, LottoNumber winningLottoNumbers) {
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
            LottoRank lottoRank = lottoNumber.lottoRank(winningLottoNumbers);
            if (lottoRank != null) {
                rank.put(lottoRank, rank.get(lottoRank) + 1);
            }
        });
    }

    private static Map<LottoRank, Integer> initializeLottoWinningBoardMap() {
        Map<LottoRank, Integer> rank = new EnumMap<>(LottoRank.class);
        for(Integer i = 3; i <= 6; i++) {
            rank.put(LottoRank.fromMatch(i), 0);
        }
        return rank;
    }
}
