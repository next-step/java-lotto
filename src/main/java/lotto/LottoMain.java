package lotto;

import lotto.domain.LottoGame;
import lotto.domain.WinningNumber;
import lotto.domain.enums.LottoRank;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Map;

public class LottoMain {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        inputView.excuteInput();
        LottoGame lottoGame = new LottoGame(inputView);

        ResultView resultView = new ResultView();
        resultView.printLotto(inputView, lottoGame);
        WinningNumber winningNumber = new WinningNumber(inputView);

        Map<LottoRank, Integer> result = LottoRank.getResult(winningNumber, lottoGame.getLottoNumbers());
        double totalRate = LottoRank.calculateRate(result, inputView.getPurchasePrice());
        resultView.printResult(result, totalRate);
    }
}