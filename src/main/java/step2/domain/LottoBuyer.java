package step2.domain;

import step2.dto.LottoStatisticsResult;
import step2.dto.WinLotteryResult;

import java.util.Objects;

import static util.Preconditions.checkArgument;

public class LottoBuyer {
    public static final String MONEY_MUST_NOT_BE_NULL = "money must not be null";
    private final Money money;
    private Lottos lottos = Lottos.EMPTY;

    private LottoBuyer(final Money money) {
        this.money = money;
    }

    public static LottoBuyer of(final Money money) {
        checkArgument(Objects.nonNull(money), MONEY_MUST_NOT_BE_NULL);
        return new LottoBuyer(money);
    }

    public static LottoBuyer of(final int money) {
        return of(Money.of(money));
    }

    public Lottos buy() {
        this.lottos = LottoStore.sell(money);
        return getLottos();
    }

    public Lottos getLottos() {
        return lottos;
    }

    public LottoStatisticsResult getWinLotteryStatistics(final String winningNumberExpression) {
        final Lotto lotto = Lotto.of(winningNumberExpression);
        return getWinLotteryStatistics(lotto);
    }

    public LottoStatisticsResult getWinLotteryStatistics(final Lotto winningLottery) {
        final WinLotteryResult result = lottos.countHitNumber(winningLottery);
        return new LottoStatisticsResult(result, getProfit(result));
    }

    private double getProfit(final WinLotteryResult result) {
        final Money prize = result.getTotalPrizeMoney();
        return prize.divide(money);
    }
}
