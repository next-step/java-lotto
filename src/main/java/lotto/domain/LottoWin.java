package lotto.domain;

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

    public Map<LottoRank, Integer> win() {
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

    public long sum() {
        long sum = 0;
        for(LottoRank lottoWinType: lottoWin.keySet()) {
            sum += lottoWinType.amount() * lottoWin.get(lottoWinType);
        }
        return sum;
    }

    public BigDecimal profit(Money money) {
        return BigDecimal.valueOf(sum()).divide(BigDecimal.valueOf(money.money()), 2, BigDecimal.ROUND_FLOOR);
    }
}
