package lotto;

import lotto.service.LottoGame;
import lotto.service.LottoResult;
import lotto.utils.Utils;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class ConsoleMain {

    public static void main(String[] args){


        LottoGame lg = new LottoGame(InputView.inputMoney());
        InputView.printLottoList(lg.getGamePlays());

        String inputWinnerNumsToString = InputView.winningNumbers();
        List<Integer> winnersNum = Utils.getIntListFromString(inputWinnerNumsToString);
        LottoResult lr = new LottoResult(lg.getGamePlays(),winnersNum,lg.getMoney());

        ResultView.gameResult();
        System.out.println(lr.matchCountResultString(winnersNum));


        //마지막 출력 소수점


    }
}
