package lotto;

import lotto.domain.*;
import lotto.infrastructure.AutoLottoNumberStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGameController {

    public static void main(String[] args) {
        LottoMoney lottoMoney = new LottoMoney(InputView.requestMoney());
        LottoGame lottoGame = new LottoGame(lottoMoney);
        LottoTickets lottoTickets = lottoGame.buy(new AutoLottoNumberStrategy());
        lottoTickets.print();
        WinningTicket winningTicket = new WinningTicket(
                InputView.requestWinningNumbers(),
                InputView.requestBonusNumber()
        );
        LottoGameResults lottoGameResults = lottoGame.match(lottoTickets, winningTicket);
        ResultView.print(lottoGameResults);
    }
}
