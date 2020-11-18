package lotto.domain;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.rank.LottoRankCalculator;
import lotto.dto.LottoStatisticsResult;
import lotto.dto.WinLotteryResult;

import static util.Preconditions.checkArgument;

public class LottoBuyer {
    public static final String MONEY_MUST_GRATE_THEN_ZERO_TO_BUY_LOTTO = "money must grate then zero to buy lotto";
    private final Money money;
    private LottoTickets lottoTickets = LottoTickets.EMPTY;

    private LottoBuyer(final Money money) {
        this.money = money;
    }

    public static LottoBuyer of(final int money) {
        return new LottoBuyer(Money.of(money));
    }

    public LottoTickets buy() {
        checkArgument(money.isNotZero(), MONEY_MUST_GRATE_THEN_ZERO_TO_BUY_LOTTO);
        this.lottoTickets = LottoStore.sell(money);
        return getLottoTickets();
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }

    public LottoStatisticsResult getWinLotteryStatistics(final String winningNumberExpression, final int bonusNumber) {
        final LottoRankCalculator lottoRankCalculator = new LottoRankCalculator();
        final LottoTicket winningLottery = LottoTicket.of(winningNumberExpression);
        final WinLotteryResult result = lottoRankCalculator.calculateWinLotteryResult(lottoTickets, winningLottery, LottoNumber.of(bonusNumber));
        return new LottoStatisticsResult(result, getProfit(result));
    }

    private double getProfit(final WinLotteryResult result) {
        final Money prize = result.getTotalPrizeMoney();
        return prize.divide(money);
    }
}
