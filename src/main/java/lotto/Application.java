package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        int inputOfAmount = InputView.askOfAmount();

        LottoTicket lottoTicket = LottoMachine.buy(Money.wons(inputOfAmount));
        OutputView.printLottoTicket(lottoTicket);

        String inputOfNumbers = InputView.askOfWinningNumbers();
        int inputOfBonusNumber = InputView.askOfWinningBonusNumber();
        WinningLottoRequest winningLottoRequest = WinningLottoRequest.of(inputOfNumbers, inputOfBonusNumber);

        WinningLotto winningLotto = LottoMachine.getWinningLotto(winningLottoRequest);

        OutputView.printReport(lottoTicket.result(winningLotto));
    }
}
