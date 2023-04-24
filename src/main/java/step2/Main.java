package step2;

import step2.service.LottoGame;
import step2.view.InputView;
import step2.view.ResultView;
import step2.vo.LottoResults;
import step2.vo.CountOfWinners;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int numOfLottoTicket = inputView.getNumOfLottoTicket();

        LottoGame lottoGame = new LottoGame(numOfLottoTicket);
        LottoResults lottoResults = lottoGame.executeGame();

        ResultView resultView = new ResultView(lottoResults);
        resultView.showLottoGameResults();

        CountOfWinners countOfWinners = new CountOfWinners(lottoResults.countNumOfWinner(inputView.getWinNumbers()));

        resultView.showLottoWinners(countOfWinners);
        resultView.showRateOfReturn(countOfWinners.calculateRateOfReturn(numOfLottoTicket));
    }
}
