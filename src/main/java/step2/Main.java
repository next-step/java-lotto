package step2;

import step2.service.LottoGame;
import step2.view.InputView;
import step2.view.ResultView;
import step2.vo.LottoResults;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int numOfLottoTicket = inputView.getNumOfLottoTicket();

        LottoGame lottoGame = new LottoGame(numOfLottoTicket);
        LottoResults lottoResults = lottoGame.executeGame();

        ResultView resultView = new ResultView(numOfLottoTicket, lottoResults);
        resultView.showLottoGameResults();

        List<Integer> winNumbers = inputView.getWinNumbers();
        LottoRank.electWinner(winNumbers, lottoResults);

        resultView.showLottoWinners();
    }
}
