package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;
import java.util.Map;

public class LottoController {

    private static final LottoController lottoController = new LottoController();

    private LottoController() {
    }

    public static LottoController getInstance() {
        return lottoController;
    }

    public void start() {
        Ticket ticket = getTicket();
        Lottos lottos = purchaseLottos(ticket);
        printTicketInfo(ticket, lottos);

        WinningLotto winningLotto = getWinningLotto();
        WinningResult winningResult = WinningResult.of(lottos, winningLotto);
        printResult(winningResult, ticket);
    }

    private Ticket getTicket() {
        try {
            int cash = InputView.inputBuyCash();
            int count = InputView.inputManualCount();
            return Ticket.of(cash, count);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return getTicket();
        }
    }

    private Lottos purchaseLottos(Ticket ticket) {
        try {
            return LottoMachine.purchase(ticket, InputView.inputManualLotto(ticket.getManualCount()));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return purchaseLottos(ticket);
        }
    }

    private WinningLotto getWinningLotto() {
        try {
            Lotto winningLotto = Lotto.from(InputView.inputWinningNumbers());
            LottoNumber bonusNumber = LottoNumber.from(InputView.inputBonusNumber());
            return new WinningLotto(winningLotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return getWinningLotto();
        }
    }

    private void printTicketInfo(Ticket ticket, Lottos lottos) {
        OutputView.printPurchaseInfo(ticket.getManualCount(), ticket.getAutoCount(), lottos.getStringLottos());
    }

    private void printResult(WinningResult winningResult, Ticket ticket) {
        Map<Rank, Integer> result = winningResult.getResult();
        BigDecimal profitRate = winningResult.calculateProfitRate(ticket.getBuyCash());
        OutputView.printWinningResult(result, profitRate);
    }
}
