package step2.domain;

import step2.domain.type.Prize;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class WinningStatistics {

    private static final int ZERO = 0;
    private static final int SCALE = 2;

    private final Map<Prize, Lottos> winningStatistics;

    private WinningStatistics(Map<Prize, Lottos> winningStatistics) {
        this.winningStatistics = winningStatistics;
    }

    public static WinningStatistics of(Lottos lottos, PrizeLotto prizeLotto) {
        return new WinningStatistics(lottos.lottos().stream().collect(
            groupingBy(
                lotto -> lotto.prize(prizeLotto),
                collectingAndThen(toList(), Lottos::new)
            )
        ));
    }

    public int winningLottoCountByPrize(Prize prize) {
        if (exist(prize)) {
            Lottos lottos = this.winningStatistics.get(prize);
            return lottos.size();
        }

        return ZERO;
    }

    private boolean exist(Prize prize) {
        return this.winningStatistics.containsKey(prize);
    }

    public BigDecimal rateOfReturn(BigDecimal paidPrice) {
        return sumOfPrizeMoney().divide(paidPrice, SCALE, RoundingMode.HALF_UP);
    }

    private BigDecimal sumOfPrizeMoney() {
        return this.winningStatistics.keySet().stream()
            .map(prize -> sumOfMoneyPerPrize(prize))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal sumOfMoneyPerPrize(Prize prize) {
        BigDecimal prizeMoney = prize.prizeMoney();
        BigDecimal winningLottoCount = BigDecimal.valueOf(winningLottoCountByPrize(prize));

        return prizeMoney.multiply(winningLottoCount);
    }

}
