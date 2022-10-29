package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void buyLotto() {
        PaidAmount paidAmount = new PaidAmount(inputView.getPaidAmount());

        int ticketInput = inputView.getManualCount();
        Tickets tickets = new Tickets(ticketInput, paidAmount);

        List<Lotto> manual = inputView.getManualLottoNumbers(tickets.getManualCount());
        Lottos lottos = new Lottos(manual, tickets.getAutoCount());

        resultView.printAllLotto(lottos, tickets);
        checkResult(lottos, paidAmount);
    }

    private void checkResult(Lottos lottos, PaidAmount paidAmount) {
        Lotto winningNumbers = new Lotto(inputView.getWinningNumbers());
        LottoNumber bonusBall = LottoNumber.of(inputView.getBonusBall());

        lottos.calculateLottoResult(winningNumbers, bonusBall, paidAmount);

        resultView.printLottoResult(lottos);
    }
}
