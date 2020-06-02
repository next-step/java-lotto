package me.daeho.lotto;

import me.daeho.lotto.domain.*;
import me.daeho.lotto.view.InputView;
import me.daeho.lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoApplication {
    public static void main(String[] args) {
        LottoPurchase purchase = InputView.purchase();

        LottoMachine lottoMachine = LottoMachine.create(
                ShuffleLottoNumber.create(LottoNumber.availableNumbers()),
                LottoPrice.defaultPrice()
        );

        List<LottoTicket> tickets = lottoMachine.buy(purchase);
        ResultView.ticketList(tickets);

        List<LottoNumber> lastWinningNumber = InputView.lastWeekWinningNum();
        LottoNumber bonusBall = InputView.bonusBall();

        Map<Rank, Integer> matchNumbers = lottoMachine.matchTicketCounts(lastWinningNumber, bonusBall, tickets);
        TotalPrize totalPrize = lottoMachine.totalPrize(matchNumbers);
        EarningRate earningRate = lottoMachine.earningRate(purchase, totalPrize);
        ResultView.statistics(matchNumbers, earningRate);
    }
}
