package step2.domain;

import step2.dto.LottoStatisticsResult;
import step2.dto.WinLotteryResult;

import static util.Preconditions.checkArgument;

public class LottoBuyer {
    public static final String MONEY_MUST_GRATE_THEN_ZERO_TO_BUY_LOTTO = "money must grate then zero to buy lotto";
    private final Money money;
    private Lottos lottos = Lottos.EMPTY;

    private LottoBuyer(final Money money) {
        this.money = money;
    }

    public static LottoBuyer of(final int money) {
        return new LottoBuyer(Money.of(money));
    }

    public Lottos buy() {
        checkArgument(money.isNotZero(), MONEY_MUST_GRATE_THEN_ZERO_TO_BUY_LOTTO);
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
        final WinLotteryResult result = lottos.getWinLotteryResult(winningLottery);
        return new LottoStatisticsResult(result, getProfit(result));
    }

    private double getProfit(final WinLotteryResult result) {
        final Money prize = result.getTotalPrizeMoney();
        return prize.divide(money);
    }
}
