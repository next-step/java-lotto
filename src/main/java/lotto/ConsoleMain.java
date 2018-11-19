package lotto;

import lotto.dto.Lotto;
import lotto.dto.Rank;
import lotto.dto.WinningLotto;
import lotto.service.LottoGame;
import lotto.service.LottoResult;
import lotto.utils.LottoMaker;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class ConsoleMain {

    public static void main(String[] args){

        LottoGame lottoGame = new LottoGame(InputView.inputMoney(), InputView.manual());
        ResultView.printAutoAndManual(lottoGame.getAutoGames(),lottoGame.getManualGames());
        List<Lotto> lottos = lottoGame.getGamePlays();
        InputView.printLottoList(lottos);

        String inputWinnerNumsToString = InputView.winningNumbers();
        int bonusNum = InputView.bonusNum();

        Map<Rank,Integer> maps = lottoGame.match(new WinningLotto(LottoMaker.of(inputWinnerNumsToString),bonusNum));
        ResultView.printMatchingResult(maps);

        LottoResult lottoResult = new LottoResult(lottoGame.getMoney() , maps);
        ResultView.printProfitResult(lottoResult);


    }
}
