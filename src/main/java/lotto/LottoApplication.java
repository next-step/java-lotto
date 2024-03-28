package lotto;

import lotto.constants.Const;
import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoApplication {

    public static void main(String[] args) {

        InputView inputView = new InputView();

        System.out.println(Const.GET_TRY_NO);

        int tryNo = inputView.tryNo(inputView.getInput());

        // 로또 생성
        LottoGame lottoGame = new LottoGame(tryNo);

        // 당첨번호를 입력받는다.
        System.out.println(Const.GET_WINNING_NO);
        List<Integer> winningNo = inputView.winningNo(inputView.getInput());

        // 당첨 로또 갯수 정산
        Map<Integer, Integer> countMap = lottoGame.countLottosByMatchingCount(winningNo);

        // 수익률을 계산한다.
        double profit = lottoGame.profitRate();

        System.out.println(Const.RESULT);
        System.out.println("-----------------");

        ResultView resultView = new ResultView();
        resultView.printResult(countMap, profit);
    }

}
