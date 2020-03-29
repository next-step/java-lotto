package step2;

import step2.domain.*;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoAutoGame {

    public static void main(String[] args) {
        int buyLottoTotalPrice = InputView.askTotalPrice();
        BuyInfo buyInfo = SetLottoGame.startLotto(buyLottoTotalPrice);
        ResultView.printBuyList(buyInfo);
        List<Integer> winnerLottoNumber = InputView.askWinnerLottoNumber();
        ResultInfo resultInfo = ResultLottoGame.resultLotto(buyInfo, winnerLottoNumber);
        resultInfo = ResultLottoGame.setResultString(resultInfo);
        resultInfo = ResultLottoGame.getProfitRate(resultInfo);
        ResultView.printResult(resultInfo);
    }
}
