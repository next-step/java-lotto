package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LottosStatistics {
    private final static int EMPTY = 0;

    private final Map<LottoRank, Integer> countByRank = new HashMap<>();
    private final BigDecimal rateOfReturnAmount;

    public LottosStatistics(List<Lotto> Lottos, BigDecimal buyPrice, WinningLotto winningLotto) {
        for (Lotto lotto: Lottos) {
            addLottoRank(lotto.getWinningRank(winningLotto));
        }
        this.rateOfReturnAmount = calculateRateOfReturnAmount(buyPrice);
    }

    private BigDecimal calculateRateOfReturnAmount(BigDecimal buyAmount) {
        BigDecimal sumAmount = BigDecimal.ZERO;
        for(LottoRank lottoRank : LottoRank.getWinningLotto(true)) {
            sumAmount = sumAmount.add(lottoRank.getWinningAmount().multiply(BigDecimal.valueOf(getWinningCount(lottoRank))));
        }
        return sumAmount.divide(buyAmount, 2, RoundingMode.HALF_UP);
    }

    public int getWinningCount(LottoRank rank) {
        return Optional.ofNullable(countByRank.get(rank)).orElse(EMPTY);
    }

    private void addLottoRank(LottoRank lottoRank) {
        Integer count = Optional.ofNullable(countByRank.get(lottoRank)).orElse(EMPTY);
        countByRank.put(lottoRank, ++count);
    }

    public float getRateOfReturnAmount() {
        return rateOfReturnAmount.floatValue();
    }
}
