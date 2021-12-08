package step2;

import step2.domain.*;
import step2.service.LottoGame;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoGameMain {

    public static void main(String[] args) {
        Money inputAmount = InputView.inputAmount();

        Ticket tickets = inputAmount.purchasedTicket();

        ResultView.renderLottoCount(tickets);

        LottoGame lottoGame = new LottoGame();
        LottoTickets lottoTickets = lottoGame.generateLotto(tickets);
        ResultView.renderLottoStatus(lottoTickets.lottoTickets());

        WinningResultInfo resultInfo = lottoTickets.matchedWinningNumber(new MatchedNumber(InputView.pickWinningNumber()));

        ResultView.renderWinningResult(resultInfo);
        ResultView.renderWinningRate(resultInfo.calculateRate(inputAmount));
    }
}
