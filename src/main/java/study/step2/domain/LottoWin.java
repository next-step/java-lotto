package study.step2.domain;

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

    public void hit(int match) {
    }

    public int sum() {
        return 0;
    }
}
