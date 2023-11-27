package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        Lottos tickets = Lottos.issue(InputView.inputMoney());

        ResultView.printCheckPurchaseMessage(tickets.count());
        ResultView.printLottoTickets(tickets);

        LottoNumbers winningNumber = LottoNumbers.of(InputView.inputWinningNumbers());
        LottoNumber bonusNumber = new LottoNumber(InputView.inputBonusBallNumber());
        LottoReport report = new LottoReport(tickets.ranks(winningNumber, bonusNumber));
        ResultView.printResultReport(report);
    }
}
