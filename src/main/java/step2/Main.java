package step2;

import step2.service.LottoGame;
import step2.view.InputView;
import step2.view.ResultView;
import step2.vo.LottoResults;
import step2.vo.WinnerInfo;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int numOfLottoTicket = inputView.getNumOfLottoTicket();

        LottoGame lottoGame = new LottoGame(numOfLottoTicket);
        LottoResults lottoResults = lottoGame.executeGame();

        ResultView resultView = new ResultView(lottoResults);
        resultView.showLottoGameResults();

        WinnerInfo winnerInfo = new WinnerInfo(lottoResults.countNumOfWinner(inputView.getWinNumbers()));

        resultView.showLottoWinners(winnerInfo);
        resultView.showRateOfReturn(winnerInfo.calculateRateOfReturn(numOfLottoTicket));
    }
}
