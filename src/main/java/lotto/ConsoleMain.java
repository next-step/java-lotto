package lotto;

import lotto.dto.Lotto;
import lotto.dto.WinningLotto;
import lotto.service.LottoGame;
import lotto.service.LottoResult;
import lotto.utils.Utils;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class ConsoleMain {

    public static void main(String[] args){

        LottoGame lg = new LottoGame(InputView.inputMoney());
        List<Lotto> lottos = lg.getGamePlays();
        InputView.printLottoList(lottos);

        String inputWinnerNumsToString = InputView.winningNumbers();
        int bonusNum = InputView.bonusNum();
        WinningLotto winnerNums = new WinningLotto(
                Utils.getIntListFromString(inputWinnerNumsToString)
                ,bonusNum);
//        List<Integer> winnersNum = Utils.getIntListFromString(inputWinnerNumsToString);
        LottoResult lr = lg.match(winnerNums);

        String result = lr.matchCountResultString(winnerNums);
        ResultView.gameResult(result);

    }
}
