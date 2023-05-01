package step2;

import step2.service.LottoGame;
import step2.view.InputView;
import step2.view.ResultView;
import step2.vo.CountOfWinners;
import step2.vo.LottoNumber;
import step2.vo.LottoResults;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int numOfLottoTicket = inputView.getNumOfLottoTicket();

        LottoGame lottoGame = new LottoGame(numOfLottoTicket);
        LottoResults lottoResults = new LottoResults(lottoGame.executeGame());

        ResultView resultView = new ResultView(lottoResults);
        resultView.showNumOfTickets(numOfLottoTicket);
        resultView.showLottoGameResults();

        List<LottoNumber> winNumbers = inputView.getWinNumbers();
        LottoNumber bonusNumber = inputView.getBonusNumber();
        CountOfWinners countOfWinners = new CountOfWinners(lottoResults.countNumOfWinner(winNumbers, bonusNumber));

        resultView.showLottoWinners(countOfWinners);
        resultView.showRateOfReturn(countOfWinners.calculateRateOfReturn(numOfLottoTicket));
    }
}
