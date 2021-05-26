package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class LottoWin {
    final Map<LottoRank, Integer> lottoWin = new EnumMap<>(LottoRank.class);

    public LottoWin() {
        Arrays.asList(LottoRank.values())
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
        return lottoWin.keySet().stream()
            .mapToLong(lottoWinType -> lottoWinType.amount() * lottoWin.get(lottoWinType))
            .sum();
    }

    public BigDecimal profit(Money money) {
        return BigDecimal.valueOf(sum())
            .divide(BigDecimal.valueOf(money.money()),
                2,
                BigDecimal.ROUND_FLOOR);
    }
}
