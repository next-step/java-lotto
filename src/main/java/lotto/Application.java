package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        int inputOfAmount = InputView.askOfAmount();
        Money moneyToBuy = Money.won(inputOfAmount);
        List<String> numbersOfManual = InputView.askManualLotto();

        long sizeOfManual = (numbersOfManual == null || numbersOfManual.isEmpty()) ? 0 : numbersOfManual.size();
        long sizeOfRandom = moneyToBuy.countAvailableByLotto() - sizeOfManual;
        OutputView.printNumberOfBuyLotto(sizeOfManual, sizeOfRandom);

        LottoTicket lottoTicket = LottoMachine.buy(moneyToBuy, numbersOfManual);
        OutputView.printLottoTicket(lottoTicket);

        String inputOfNumbers = InputView.askOfWinningNumbers();
        int inputOfBonusNumber = InputView.askOfWinningBonusNumber();
        WinningLotto winningLotto = WinningLotto.of(inputOfNumbers, inputOfBonusNumber);

        LottoResult result = lottoTicket.result(winningLotto);
        OutputView.printReport(result);

        OutputView.printRateOfReturn(RateOfReturn.calculate(result));
    }
}
