package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumber;
import lotto.domain.enums.LottoRank;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.Map;

public class lottoGenerator {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int buyPrice = inputView.inputMoney();             //(총)구입금액
        int buyManualPrice = inputView.inputManualMoney(); //수동구매금액
        buyPrice = buyPrice - buyManualPrice;              // 자동구매금액 = 구입금액-수동구매금액

        ResultView resultView2 = new ResultView();
        resultView2.printBuyTicket(buyManualPrice/1000, buyPrice/1000);

        LottoGame lottoGame = new LottoGame(buyPrice);
        ArrayList<LottoTicket> ticket = lottoGame.buyLotto();

        ArrayList<Integer> winningNums = inputView.inputWinningNum();
        int bonusNum = inputView.inputBonusNum();
        WinningNumber winningNumber = new WinningNumber(winningNums, bonusNum);

        Map<LottoRank, Integer> result = LottoRank.getResult(winningNumber, ticket);
        double totalRate = lottoGame.calculateRate(result);

        ResultView resultView = new ResultView();
        resultView.printResult(result, totalRate);
    }
}