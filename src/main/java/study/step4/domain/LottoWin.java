package study.step4.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class LottoWin {
    Map<LottoRank, Integer> lottoWin = new LinkedHashMap<>();

    public LottoWin() {
        Arrays.stream(LottoRank.values())
            .forEach(lottoRank -> lottoWin.put(lottoRank, 0));
    }

    public Map<LottoRank, Integer> getWin() {
        return lottoWin;
    }

    public void hit(int match) {
        LottoRank lottoWinType = LottoRank.of(match, false);
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
            int multiple = lottoWinType.getMoney() * lottoWin.get(lottoWinType);
            sum += multiple;
        }
        return sum;
    }

    public BigDecimal profit(LottoMoney lottoMoney) {
        return BigDecimal.valueOf(sum()).divide(BigDecimal.valueOf(lottoMoney.getMoney()), 2, BigDecimal.ROUND_FLOOR);
    }
}
