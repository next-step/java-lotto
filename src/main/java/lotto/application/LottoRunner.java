package lotto.application;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoRunner {
    public static void main(String[] args) {
        OutputView.printMoneyInput();
        Money money = InputView.getMoney();
        OutputView.printHowManyLottoTickets(money);

        LottoTickets lottoTickets = LottoTicketsFactory.createAuto(money);
        OutputView.printBoughtLottoTickets(lottoTickets);

        OutputView.printWinningTicketInput();
        LottoTicket winningTicket = InputView.getWinningTicket();

        LottoPrize lottoPrize = lottoTickets.checkResult(winningTicket);
        OutputView.printStatistics(money, lottoPrize);
    }
}
