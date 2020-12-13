package com.nextstep.lotto.application;

import com.nextstep.lotto.domain.*;
import com.nextstep.lotto.view.InputView;
import com.nextstep.lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoRunner {
    public static void main(String[] args) {
        Money originalMoney = getMoneyFromUser();

        int numberOfStaticLotto = getNumberOfStaticLottoFromUser();

        LottoTickets staticLottoTickets = getStaticLottoTicketsFromUser(numberOfStaticLotto);

        LottoTickets lottoTickets = buyAutoLottoTicketsByRemainMoney(originalMoney, staticLottoTickets);

        WinningTicket winningTicket = lotteryWinningTicket();

        showFinalLottoResult(lottoTickets, winningTicket, originalMoney);
    }

    private static Money getMoneyFromUser() {
        OutputView.printMoneyInput();
        return InputView.getMoney();
    }

    private static int getNumberOfStaticLottoFromUser() {
        OutputView.printStaticLottoCountInput();
        return InputView.getNumberOfStaticLotto();
    }

    private static LottoTickets getStaticLottoTicketsFromUser(final int numberOfStaticLotto) {
        OutputView.printStaticLottoNumberInput();
        List<LottoTicket> staticLottoTickets = new ArrayList<>();
        for (int i = 0; i < numberOfStaticLotto; i++) {
            LottoTicket lottoTicket = InputView.getLottoTicket();
            staticLottoTickets.add(lottoTicket);
        }

        return new LottoTickets(staticLottoTickets);
    }

    private static LottoTickets buyAutoLottoTicketsByRemainMoney(
            final Money originalMoney, final LottoTickets staticLottoTickets
    ) {
        Money remainMoney = originalMoney.minusBoughtLottoTickets(staticLottoTickets.size());
        OutputView.printHowManyLottoTickets(staticLottoTickets.size(), remainMoney);

        return LottoTicketsFactory.creatAutoByRemainedMoney(originalMoney, staticLottoTickets);
    }

    private static WinningTicket lotteryWinningTicket() {
        OutputView.printWinningTicketInput();
        LottoTicket winningTicket = InputView.getLottoTicket();

        OutputView.printBonusNumberInput();
        LottoNumber bonusNumber = InputView.getBonusNumber();

        return new WinningTicket(winningTicket, bonusNumber);
    }

    private static void showFinalLottoResult(
            final LottoTickets lottoTickets, final WinningTicket winningTicket, final Money originalMoney
    ) {
        LottoPrize lottoPrize = lottoTickets.checkResult(winningTicket);
        OutputView.printStatistics(originalMoney, lottoPrize);
    }
}
