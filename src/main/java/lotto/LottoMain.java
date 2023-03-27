package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumber;
import lotto.domain.enums.LottoRank;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoMain {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        int gameCnt = inputView.inputMoney();
        int manualCnt = inputView.inputManualCnt(gameCnt);
        int autoCnt = gameCnt - manualCnt;
        List<LottoTicket> manualLotto = inputView.inputManualNums(manualCnt);

        LottoGame lottoGame = new LottoGame(autoCnt, manualLotto);
        ResultView resultView = new ResultView();
        resultView.printLotto(manualCnt, autoCnt, lottoGame.getLottoNumbers());
        WinningNumber winningNumber = new WinningNumber(inputView);

        Map<LottoRank, Integer> result = LottoRank.getResult(winningNumber, lottoGame.getLottoNumbers());
        double totalRate = LottoRank.calculateRate(result, gameCnt);
        resultView.printResult(result, totalRate);
    }
}