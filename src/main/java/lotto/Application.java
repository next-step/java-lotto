package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {

    private static final LottoMachine lottoMachine = new LottoMachine();

    public static void main(String[] args) {
        int inputOfAmount = InputView.askOfAmount();
        Money moneyToBuy = Money.won(inputOfAmount);

        List<String> manual = InputView.askManualLotto();
        PurchaseRequest purchaseRequest = PurchaseRequest.of(moneyToBuy, manual);
        OutputView.printNumberOfBuyLotto(purchaseRequest);

        LottoTicket lottoTicket = lottoMachine.buy(PurchaseRequest.of(moneyToBuy, manual));
        OutputView.printLottoTicket(lottoTicket);

        String inputOfNumbers = InputView.askOfWinningNumbers();
        int inputOfBonusNumber = InputView.askOfWinningBonusNumber();
        WinningLotto winningLotto = LottoMachine.generateWinningLotto(inputOfNumbers, inputOfBonusNumber);

        LottoResult result = lottoTicket.result(winningLotto);
        OutputView.printReport(result);

        OutputView.printRateOfReturn(RateOfReturn.calculate(result));
    }
}
