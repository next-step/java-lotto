package step2;

import static step2.utils.Converter.convertTo;
import static step2.view.InputView.inputPurchasePrice;
import static step2.view.InputView.inputWinningLottoNumber;
import static step2.view.OutputView.printLottoNumber;
import static step2.view.OutputView.printLottoStatistics;
import static step2.view.OutputView.printProfitResult;

import step2.model.LottoResults;
import step2.model.LottoStore;
import step2.model.Payment;
import step2.model.PurchasedLottoTickets;
import step2.model.WinningLottoTicket;

public class Main {
    public static void main(String[] args) {
        int purchasePrice = inputPurchasePrice();
        PurchasedLottoTickets purchasedLottoTickets = LottoStore.sell(Payment.of(purchasePrice));

        printLottoNumber(purchasedLottoTickets);

        String inputWinningLottoNumberString = inputWinningLottoNumber();
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.createBy(convertTo(inputWinningLottoNumberString));

        LottoResults lottoResults = purchasedLottoTickets.match(winningLottoTicket);

        printLottoStatistics(lottoResults);

        printProfitResult(lottoResults.getProfit());
    }
}
