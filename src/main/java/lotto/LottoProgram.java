package lotto;

import static lotto.view.InputView.*;
import static lotto.view.InputView.inputBonusNumber;
import static lotto.view.InputView.inputManualLottoCount;
import static lotto.view.InputView.inputPurchaseAmount;
import static lotto.view.InputView.inputWinningNumbers;
import static lotto.view.ResultView.printLottosCount;
import static lotto.view.ResultView.printPurchaseLottoByEachType;
import static lotto.view.ResultView.printReturnRate;
import static lotto.view.ResultView.printWinningResult;

import lotto.view.Customer;

public class LottoProgram {

    public void run() {
        Money money = new Money(inputPurchaseAmount());
        PurchaseAmount amount = PurchaseAmount.of(money.purchase(), inputManualLottoCount());

        Customer customer = buyLotto(amount);
        printPurchaseLottoByEachType(amount);
        printLottosCount(customer.getLottos());

        WinningLotto winningLotto = WinningLotto.of(inputWinningNumbers(), inputBonusNumber());

        LottoResult lottoResult = winningLotto.getWinningResult(customer.getLottos());
        printWinningResult(lottoResult);
        printReturnRate(lottoResult.calculateReturnRate(amount.getTotal()));
    }

    private static Customer buyLotto(PurchaseAmount amount) {
        Customer customer = Customer.of(amount);
        customer.buyManualLotto(inputManualLottoNumbers(amount.getManual()));
        customer.buyAutoLotto();
        return customer;
    }
}
