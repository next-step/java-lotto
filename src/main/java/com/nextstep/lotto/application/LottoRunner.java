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
        // TODO: WinningTicket을 받아서 처리하는 부분에서 BonusNumber도 처리할 수 있도록 변경되야 함
        LottoTicket winningTicket = InputView.getWinningTicket();
        WinningTicket tempWinningTicketForTest = new WinningTicket(winningTicket, new LottoNumber(10));

        LottoPrize lottoPrize = lottoTickets.checkResult(tempWinningTicketForTest);
        OutputView.printStatistics(money, lottoPrize);
    }
}
