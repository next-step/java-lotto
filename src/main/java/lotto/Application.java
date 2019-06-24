package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        int inputOfAmount = InputView.askOfAmount();

        LottoTicket lottoTicket = LottoMachine.buy(Money.wons(inputOfAmount));
        OutputView.printLottoTicket(lottoTicket);

        String number = "1,2,3,3,4,5";
        int bonus = 7;

        Lotto winningLotto = LottoMachine.getWinningLotto(InputView.askOfWinningNumbers());
        WinningLotto winningLotto2 = LottoMachine.getWinningLotto(WinningLottoRequest.of(number, bonus));

//        OutputView.printReport(lottoTicket.result(winningLotto));
    }
}
