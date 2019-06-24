package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        Money money = InputView.askOfAmount();

        LottoTicket lottoTicket = LottoMachine.buy(money);
        OutputView.printLottoTicket(lottoTicket);

        Lotto winningLotto = LottoMachine.getWinningLotto(InputView.askOfWinningNumbers());

        OutputView.printReport(lottoTicket.result(winningLotto));
    }
}
