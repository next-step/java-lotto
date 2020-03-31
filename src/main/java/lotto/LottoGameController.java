package lotto;

import lotto.domain.*;
import lotto.infrastructure.AutoLottoNumberStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGameController {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        LottoMachine lottoMachine = new LottoMachine(inputView.lottoGameDto());
        LottoTickets lottoTickets = lottoMachine.buyAuto(new AutoLottoNumberStrategy());

        LottoGame lottoGame = new LottoGame(lottoTickets);
        ResultView.print(lottoGame);

        WinningTicket winningTicket = new WinningTicket(inputView.getWinningDto());
        LottoGameResults lottoGameResults = lottoGame.match(winningTicket);
        ResultView.print(lottoGameResults);
    }
}
