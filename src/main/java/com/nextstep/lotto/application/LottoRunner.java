package com.nextstep.lotto.application;

import com.nextstep.lotto.domain.*;
import com.nextstep.lotto.view.InputView;
import com.nextstep.lotto.view.OutputView;

public class LottoRunner {
    public static void main(String[] args) {
        Money originalMoney = getMoneyFromUser();

        int numberOfStaticLotto = getNumberOfStaticLottoFromUser();

        LottoTickets boughtLottoTickets = buyLottoTickets(numberOfStaticLotto, originalMoney);

        WinningTicket winningTicket = lotteryWinningTicket();

        showFinalLottoResult(boughtLottoTickets, winningTicket, originalMoney);
    }

    private static Money getMoneyFromUser() {
        OutputView.printMoneyInput();
        return InputView.getMoney();
    }

    private static int getNumberOfStaticLottoFromUser() {
        OutputView.printStaticLottoCountInput();
        return InputView.getNumberOfStaticLotto();
    }

    private static LottoTickets buyLottoTickets(
            final int numberOfStaticLotto, final Money originalMoney
    ) {
        OutputView.printStaticLottoNumberInput();
        LottoShop lottoShop = new LottoShop(originalMoney);
        for (int i = 0; i < numberOfStaticLotto; i++) {
            LottoTicket lottoTicket = InputView.getLottoTicket();
            lottoShop.buyStaticLottoTicket(lottoTicket);
        }

        LottoTickets lottoTickets = lottoShop.buyAutoLottoTicketsByRemainedMoney();

        OutputView.printHowManyLottoTickets(lottoShop.howManyStaticBoughtLottoTickets(), lottoShop.getRemainedMoney());
        OutputView.printBoughtLottoTickets(lottoTickets);

        return lottoTickets;
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
