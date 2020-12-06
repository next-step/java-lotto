package lotto;

import lotto.ui.InputView;
import lotto.ui.OutputView;

import java.util.List;

public class LottoApp {

    public static void main(String[] args) {
        int purchasePrice = InputView.inputPrice();

        int purchaseCount = PurchaseNumberCalculation.calculateNumberPurchase(purchasePrice);

        LottoTickets lottoTickets = new LottoTicketCreation().createTickets(purchaseCount);
        OutputView.printTicketList(lottoTickets, purchasePrice);

        List<Integer> lastWeeksWinningNumbers = InputView.inputLastWeeksWinningNumbers();
        LottoGame lottoGame = new LottoGame(lottoTickets, lastWeeksWinningNumbers);
        OutputView.printResult(lottoGame.getLottoResult());
    }
}
