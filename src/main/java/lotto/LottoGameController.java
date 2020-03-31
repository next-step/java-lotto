package lotto;

import lotto.domain.*;
import lotto.infrastructure.AutoLottoNumberStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGameController {

    public static void main(String[] args) {
        LottoMoney lottoMoney = new LottoMoney(InputView.requestMoney());
        LottoMachine lottoMachine = new LottoMachine(lottoMoney);
        LottoTickets lottoTickets = lottoMachine.buy(new AutoLottoNumberStrategy());

        LottoGame lottoGame = new LottoGame(lottoTickets);
        WinningTicket winningTicket = new WinningTicket(
                InputView.requestWinningNumbers(),
                InputView.requestBonusNumber()
        );
        LottoGameResults lottoGameResults = lottoGame.match(winningTicket);
        ResultView.print(lottoGameResults);
    }
}
