package lotto;

import lotto.model.LottoMachine;
import lotto.model.Money;
import lotto.model.WinningLotto;
import lotto.model.generator.ManualGenerator;
import lotto.view.InputView;

public class Application {

    public static void main(String[] args) {
        int inputOfAmount = InputView.askOfAmount();
        Money moneyToBuy = Money.won(inputOfAmount);

//        new LottoMachine(new ManualGenerator())


//        LottoTicket lottoTicket = LottoMachine.buy(moneyToBuy);
//        OutputView.printLottoTicket(lottoTicket);

        String inputOfNumbers = InputView.askOfWinningNumbers();
        int inputOfBonusNumber = InputView.askOfWinningBonusNumber();

        WinningLotto winningLotto = LottoMachine.generateWinningLotto(inputOfNumbers, inputOfBonusNumber);

//        OutputView.printReport(lottoTicket.result(winningLotto));
    }
}
