package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        int inputOfAmount = InputView.askOfAmount();

        LottoTicket lottoTicket = LottoMachine.buy(Money.wons(inputOfAmount));
        OutputView.printLottoTicket(lottoTicket);

        Lotto winningLotto = LottoMachine.getWinningLotto(InputView.askOfWinningNumbers());

        OutputView.printReport(lottoTicket.result(winningLotto));
    }
}
