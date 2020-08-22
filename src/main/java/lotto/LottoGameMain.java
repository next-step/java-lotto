package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGameMain {
    public static void main(String[] args) {
        int money = InputView.inputMoney();
        LottoSeller lottoSeller = new LottoSeller(money);
        OutputView.printTicketCount(lottoSeller);

        LottoMachine lottoMachine = new LottoMachine(lottoSeller.getTicketCount());
        List<LottoTicket> lottoTickets = lottoMachine.issueTickets();
        OutputView.printBuyingTickets(lottoTickets);

        List<Integer> lastWeekWinningNumbers = InputView.inputLastweekWinningNumbers();
        LottoNumberMatcher lottoNumberMatcher = new LottoNumberMatcher(lastWeekWinningNumbers, lottoTickets);
        double profit = lottoNumberMatcher.calculateProfit(money);
        OutputView.printResult(lottoNumberMatcher);
        OutputView.printProfit(profit);
    }
}
