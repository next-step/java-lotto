package lotto;

import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoApplication {

    public static void main(String[] args) {

        InputView inputView = new InputView();

        // 로또 장수를 입력받는다.
        int tryNo = inputView.tryNo(inputView.getInput());

        // 로또를 생성한다.
        LottoGame lottoGame = new LottoGame(tryNo);

        // 당첨번호를 입력받는다.
        List<Integer> winningNo = inputView.winningNo(inputView.getInput());

        // 당첨 로또 갯수 정산한다.
        Map<Integer, Integer> countMap = lottoGame.countLottosByMatchingCount(winningNo);

        // 수익률을 계산한다.
        double profit = lottoGame.profitRate();

        // 로또 결과를 출력한다.
        ResultView resultView = new ResultView();
        resultView.printResult(countMap, profit);
    }

}
