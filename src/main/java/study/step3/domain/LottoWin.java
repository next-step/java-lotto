package study.step3.domain;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class LottoWin {
    Map<LottoRank, Integer> lottoWin = new LinkedHashMap<>();

    public LottoWin() {
        lottoWin.put(LottoRank.FIFTH, 0);
        lottoWin.put(LottoRank.FOURTH, 0);
        lottoWin.put(LottoRank.THIRD, 0);
        lottoWin.put(LottoRank.SECOND, 0);
        lottoWin.put(LottoRank.FIRST, 0);
    }

    public Map<LottoRank, Integer> getWin() {
        return lottoWin;
    }

    public void hit(int match) {
        LottoRank lottoWinType = LottoRank.of(match);
        addWin(lottoWinType);
    }

    public void hit(int match, boolean matchBonus) {
        LottoRank lottoWinType = LottoRank.of(match, matchBonus);
        addWin(lottoWinType);
    }

    private void addWin(LottoRank lottoRank) {
        if(lottoRank != LottoRank.MISS) {
            lottoWin.put(lottoRank, lottoWin.get(lottoRank) + 1);
        }
    }

    public int sum() {
        int sum = 0;
        for(LottoRank lottoWinType: lottoWin.keySet()) {
            int multiple = lottoWinType.getAmount() * lottoWin.get(lottoWinType);
            sum += multiple;
        }
        return sum;
    }

    public BigDecimal profit(Amount amount) {
        return new BigDecimal((double) sum() / amount.getAmount());
    }
}
