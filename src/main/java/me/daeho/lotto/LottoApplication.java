package me.daeho.lotto;

import me.daeho.lotto.domain.LottoMachine;
import me.daeho.lotto.domain.LottoTicket;
import me.daeho.lotto.domain.WinningPrize;
import me.daeho.lotto.view.InputView;
import me.daeho.lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoApplication {
    public static void main(String[] args) {
        WinningPrize winningPrize = WinningPrize.create()
                .setting(3, 5000)
                .setting(4, 50000)
                .setting(5, 1500000)
                .setting(6, 2000000000);

        int amount = InputView.amount();

        LottoMachine lottoMachine = LottoMachine.create(1_000, winningPrize);
        List<LottoTicket> tickets = lottoMachine.buyRandom(amount);
        ResultView.ticketList(tickets);

        Map<Integer, Integer> matchNumbers = lottoMachine.matchTicketCounts(InputView.lastWeekWinningNum(), tickets);
        int totalPrize = lottoMachine.totalPrize(matchNumbers);
        double earningRate = lottoMachine.earningRate(amount, totalPrize);

        ResultView.statistics(winningPrize, matchNumbers, earningRate);
    }
}
