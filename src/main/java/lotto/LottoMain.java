package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumber;
import lotto.domain.enums.LottoRank;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.Map;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int buyPrice = inputView.inputMoney();
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
