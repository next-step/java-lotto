package lotto.domain;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTicketGroup;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.rank.LottoRankCalculator;
import lotto.dto.LottoStatisticsResult;
import lotto.dto.WinLotteryResult;
import util.CollectionUtil;

import java.util.List;
import java.util.stream.Collectors;

import static util.Preconditions.checkArgument;

public class LottoGame {
    public static final String MONEY_MUST_GRATE_THEN_ZERO_TO_BUY_LOTTO = "money must grate then zero to buy lotto";
    private final Money money;
    private LottoTicketGroup lottoTicketGroup = LottoTicketGroup.EMPTY;

    private LottoGame(final Money money) {
        this.money = money;
    }

    public static LottoGame of(final long money) {

        return new LottoGame(Money.of(money));
    }

    public LottoTicketGroup buyLotto(final List<String> lottoNumberExpressionList) {
        checkArgument(money.isNotZero(), MONEY_MUST_GRATE_THEN_ZERO_TO_BUY_LOTTO);

        if (CollectionUtil.isEmpty(lottoNumberExpressionList)) {
            this.lottoTicketGroup = LottoStore.sell(money);
            return getLottoTicketGroup();
        }

        return buyLottoWithManualMode(lottoNumberExpressionList);
    }

    private LottoTicketGroup buyLottoWithManualMode(final List<String> lottoNumberExpressionList) {
        final LottoTicketGroup manualLottoTicketGroup = LottoTicketGroup.of(lottoNumberExpressionList.stream()
                .map(LottoTicket::of)
                .collect(Collectors.toList()));

        this.lottoTicketGroup = LottoStore.sell(money, manualLottoTicketGroup);
        return getLottoTicketGroup();
    }

    public LottoTicketGroup getLottoTicketGroup() {
        return lottoTicketGroup;
    }

    public LottoStatisticsResult getWinLotteryStatistics(final String winningNumberExpression, final int bonusNumber) {
        final LottoRankCalculator lottoRankCalculator = new LottoRankCalculator();
        final LottoTicket winningLotto = LottoTicket.of(winningNumberExpression);
        final WinLotteryResult result = lottoRankCalculator.calculateWinLotteryResult(lottoTicketGroup, WinningLotto.of(winningLotto, LottoNumber.of(bonusNumber)));
        return new LottoStatisticsResult(result, getProfit(result));
    }

    private double getProfit(final WinLotteryResult result) {
        final Money prize = result.getTotalPrizeMoney();
        return prize.divide(money);
    }
}
