package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LottoWin {
    Map<LottoRank, Integer> lottoWin = new LinkedHashMap<>();

    public LottoWin() {
        lottoWin.put(LottoRank.FOURTH, 0);
        lottoWin.put(LottoRank.THIRD, 0);
        lottoWin.put(LottoRank.SECOND, 0);
        lottoWin.put(LottoRank.FIRST, 0);
    }

    public Map<LottoRank, Integer> win() {
        return lottoWin;
    }

    public void hit(int match) {
        LottoRank lottoWinType = LottoRank.of(match);
        if(lottoWinType != LottoRank.MISS) {
            lottoWin.put(lottoWinType, lottoWin.get(lottoWinType) + 1);
        }
    }

    public long sum() {
        long sum = 0;
        for(LottoRank lottoWinType: lottoWin.keySet()) {
            sum += lottoWinType.amount() * lottoWin.get(lottoWinType);
        }
        return sum;
    }
}
