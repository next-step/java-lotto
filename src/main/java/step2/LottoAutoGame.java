package step2;

import step2.domain.BuyInfo;
import step2.domain.ResultInfo;
import step2.domain.ControlLottoGame;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoAutoGame {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int buyLottoTotalPrice = inputView.askTotalPrice();

        ControlLottoGame controlLottoGame = new ControlLottoGame();
        BuyInfo buyInfo = controlLottoGame.startLotto(buyLottoTotalPrice);

        ResultView resultView = new ResultView();
        resultView.printBuyList(buyInfo);

        List<Integer> winnerLottoNumber = inputView.askWinnerLottoNumber();

        ResultInfo resultInfo = controlLottoGame.resultLotto(buyInfo, winnerLottoNumber);
        resultInfo = controlLottoGame.setResultString(resultInfo);
        resultView.printResult(resultInfo);
    }
}
