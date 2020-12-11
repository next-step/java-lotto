package com.nextstep.lotto.application;

import com.nextstep.lotto.domain.*;
import com.nextstep.lotto.view.InputView;
import com.nextstep.lotto.view.OutputView;

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
