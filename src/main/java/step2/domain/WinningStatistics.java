package step2.domain;

import step2.domain.type.Prize;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.Map;

public class WinningStatistics {

    private static final int SCALE = 2;

    private final Map<Prize, Lottos> winningStatistics;

    public WinningStatistics(Map<Prize, Lottos> winningStatistics) {
        this.winningStatistics = winningStatistics;
    }

    public int winningLottosCount(Prize prize) {
        return winningLottos(prize).size();
    }

    private Lottos winningLottos(Prize prize) {
        if (exist(prize)) {
            return this.winningStatistics.get(prize);
        }

        return new Lottos(Collections.emptyList());
    }

    private boolean exist(Prize prize) {
        return this.winningStatistics.containsKey(prize);
    }

    public BigDecimal rateOfReturn(BigDecimal paidPrice) {
        return sumOfPrizeMoney().divide(paidPrice, SCALE, RoundingMode.HALF_UP);
    }

    private BigDecimal sumOfPrizeMoney() {
        BigDecimal result = BigDecimal.ZERO;
        for (Prize prize : this.winningStatistics.keySet()) {
            result = result.add(moneyPerPrize(prize));
        }

        return result;
    }

    private BigDecimal moneyPerPrize(Prize prize) {
        BigDecimal prizeMoney = prize.prizeMoney();
        BigDecimal winningLottoCount = BigDecimal.valueOf(winningLottosCount(prize));

        return prizeMoney.multiply(winningLottoCount);
    }

}
