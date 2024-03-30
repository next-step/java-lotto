package lotto;

import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Map;
import java.util.Set;

public class LottoApplication {

    public static void main(String[] args) {

        InputView inputView = new InputView();

        // 로또 구매 금액을 입력받는다.
        int buyingAmount = inputView.buyingAmount(inputView.getBuyingAmountInput());

        // 로또를 생성한다.
        LottoGame lottoGame = new LottoGame(buyingAmount);

        // 당첨번호를 입력받는다.
        Set<Integer> winningNo = inputView.winningNo(inputView.getWinningNoInput());

        // 당첨 로또 갯수 정산한다.
        Map<Integer, Integer> countMap = lottoGame.countLottosByMatchingCount(winningNo);

        // 수익률을 계산한다.
        double profit = lottoGame.profitRate();

        // 로또 결과를 출력한다.
        ResultView resultView = new ResultView();
        resultView.printResult(countMap, profit);
    }

}
