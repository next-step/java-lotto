package me.daeho.lotto;

import me.daeho.lotto.domain.*;
import me.daeho.lotto.view.InputView;
import me.daeho.lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoApplication {
    public static void main(String[] args) {
        int amount = InputView.amount();

        LottoMachine lottoMachine = LottoMachine.create(RandomLottoNumber.create(LottoNumber.availableNumbers()),1_000);
        List<LottoTicket> tickets = lottoMachine.buyRandom(amount);
        ResultView.ticketList(tickets);

        Map<Integer, Integer> matchNumbers = lottoMachine.matchTicketCounts(InputView.lastWeekWinningNum(), tickets);
        int totalPrize = lottoMachine.totalPrize(matchNumbers);
        double earningRate = lottoMachine.earningRate(amount, totalPrize);
        ResultView.statistics(matchNumbers, earningRate);
    }
}
