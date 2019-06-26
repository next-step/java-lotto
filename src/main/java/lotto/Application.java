package lotto;

import lotto.model.*;
import lotto.model.generator.WinningGenerator;
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

        LottoTicket lottoTicket = lottoMachine.buy(purchaseRequest);
        OutputView.printLottoTicket(lottoTicket);

        String inputOfNumbers = InputView.askOfWinningNumbers();
        int inputOfBonusNumber = InputView.askOfWinningBonusNumber();
        WinningLotto winningLotto = WinningGenerator.generate(inputOfNumbers, inputOfBonusNumber);

        LottoResult result = lottoTicket.result(winningLotto);
        OutputView.printReport(result);

        OutputView.printRateOfReturn(RateOfReturn.calculate(result));
    }
}
