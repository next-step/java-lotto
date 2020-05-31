package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        PurchasePrice purchasePrice = InputView.getPurchasePrice();
        List<LottoTicket> manualTickets = InputView.getManualTickets(InputView.getManualLottoCount());
        PurchaseInfo purchaseInfo = PurchaseInfo.newInstance(purchasePrice, manualTickets);

        LottoGame lottoGame = new LottoGame(purchaseInfo);
        LottoTickets lottoTickets = lottoGame.createAutoLottoTickets();

        ResultView.printPurchaseCount(lottoTickets);
        ResultView.printLottoNumbers(lottoTickets.toList());

        LottoTicket lastWinLottoTicket = LottoTicket.newWinLottoTicket(InputView.getLastWeekLottoNumbers());
        LottoNumber bonusNumber = InputView.getBonusNumber(lastWinLottoTicket);

        LottoMatchResult lottoMatchResult = lottoGame.calculateMatchCount(lastWinLottoTicket, bonusNumber);
        ResultView.printMatchResult(lottoMatchResult);
        ResultView.printProfitRate(lottoMatchResult, purchasePrice);
    }
}
