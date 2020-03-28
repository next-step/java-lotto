package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoGameResults;
import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGameController {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(InputView.requestMoney());

        LottoTickets boughtTickets = lottoGame.buy();
        boughtTickets.print();
        LottoGameResults results = lottoGame.getResults(boughtTickets, InputView.requestWinningNumber());

        ResultView.print(results);
    }
}
