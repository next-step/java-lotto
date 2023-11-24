package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public static void main(String[] args) {
        buyLottoAndCheckResult();
    }

    public static void buyLottoAndCheckResult() {
        Lottos tickets = buyLotto();
        ResultView.printCheckPurchaseMessage(tickets.count());
        ResultView.printLottoTickets(tickets);

        checkLottoResult(tickets);
    }

    private static Lottos buyLotto() {
        int money = InputView.inputMoney();
        return Lottos.issue(money);
    }

    private static void checkLottoResult(Lottos tickets) {
        LottoNumbers winningNumber = LottoNumbers.of(InputView.inputWinningNumbers());
        LottoNumber bonusNumber = new LottoNumber(InputView.inputBonusBallNumber());
        LottoReport report = new LottoReport(tickets.ranks(winningNumber, bonusNumber));
        ResultView.printResultReport(report);
    }
}
