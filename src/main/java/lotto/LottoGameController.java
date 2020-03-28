package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoGameResults;
import lotto.domain.LottoTickets;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGameController {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        LottoTickets boughtTickets = lottoGame.buy(InputView.requestMoney());
        boughtTickets.print();

        List<Integer> lottoNumber = InputView.requestWinningNumber();
        int bonusNumber = InputView.requestBonusNumber();
        WinningNumber winningNumber = new WinningNumber(lottoNumber, bonusNumber);
        LottoGameResults results = lottoGame.getResults(boughtTickets, winningNumber);
        ResultView.print(results);
    }
}
