package lotto;

import static lotto.utils.Converter.convertTo;
import static lotto.view.InputView.inputBonusLottoNumber;
import static lotto.view.InputView.inputPurchasePrice;
import static lotto.view.InputView.inputWinningLottoNumber;
import static lotto.view.OutputView.printLottoNumber;
import static lotto.view.OutputView.printLottoStatistics;
import static lotto.view.OutputView.printProfitResult;

import lotto.model.LottoResults;
import lotto.model.Payment;
import lotto.model.LottoNumber;
import lotto.model.LottoStore;
import lotto.model.PurchasedLottoTickets;
import lotto.model.WinningLottoTicket;

public class Main {
    public static void main(String[] args) {
        int purchasePrice = inputPurchasePrice();
        PurchasedLottoTickets purchasedLottoTickets = LottoStore.sell(Payment.of(purchasePrice));

        printLottoNumber(purchasedLottoTickets);

        String inputWinningLottoNumberString = inputWinningLottoNumber();
        int inputBonusLottoNumber = inputBonusLottoNumber();
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.createBy(
            convertTo(inputWinningLottoNumberString), LottoNumber.of(inputBonusLottoNumber)
        );

        LottoResults lottoResults = purchasedLottoTickets.match(winningLottoTicket);
        printLottoStatistics(lottoResults);
        printProfitResult(lottoResults.getProfit());
    }
}
