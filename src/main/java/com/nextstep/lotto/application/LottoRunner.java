package com.nextstep.lotto.application;

import com.nextstep.lotto.domain.*;
import com.nextstep.lotto.view.InputView;
import com.nextstep.lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoRunner {
    public static void main(String[] args) {
        OutputView.printMoneyInput();
        Money originalMoney = InputView.getMoney();

        OutputView.printStaticLottoCountInput();
        int numberOfStaticLotto = InputView.getNumberOfStaticLotto();

        OutputView.printStaticLottoNumberInput();
        List<LottoTicket> staticLottoTicketInputs = new ArrayList<>();
        for (int i = 0; i < numberOfStaticLotto; i++) {
            LottoTicket lottoTicket = InputView.getLottoTicket();
            staticLottoTicketInputs.add(lottoTicket);
        }

        Money remainMoney = originalMoney.minusBoughtLottoTickets(numberOfStaticLotto);
        OutputView.printHowManyLottoTickets(numberOfStaticLotto, remainMoney);

        LottoTickets staticLottoTickets = new LottoTickets(staticLottoTicketInputs);
        LottoTickets autoLottoTickets = LottoTicketsFactory.createAuto(remainMoney);
        LottoTickets lottoTickets = staticLottoTickets.merge(autoLottoTickets);
        OutputView.printBoughtLottoTickets(lottoTickets);

        OutputView.printWinningTicketInput();
        LottoTicket winningTicket = InputView.getLottoTicket();

        OutputView.printBonusNumberInput();
        LottoNumber bonusNumber = InputView.getBonusNumber();

        LottoPrize lottoPrize = lottoTickets.checkResult(new WinningTicket(winningTicket, bonusNumber));
        OutputView.printStatistics(originalMoney, lottoPrize);
    }
}
