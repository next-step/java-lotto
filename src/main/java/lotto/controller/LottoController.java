package lotto.controller;

import lotto.domain.Amount;
import lotto.domain.LottoPlay;
import lotto.domain.Winning;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private InputView inputView;
    private LottoPlay lottoPlay;

    public LottoController(InputView inputView, LottoPlay lottoPlay) {
        this.inputView = inputView;
        this.lottoPlay = lottoPlay;
    }

    public void run() {
        int inputBuyAmount = inputView.inputBuyAmount();
        
        lottoPlay.createLotto(inputBuyAmount);
        
        ResultView resultView = new ResultView();

        Map<Integer, List<Integer>> lottoNumbers = lottoPlay.getLottoNumbers();
        resultView.printLottoNumbers(lottoNumbers);

        int[] winningNumber = inputView.inputWinningNumber();

        Winning winning = new Winning();
        for (Integer integer : lottoNumbers.keySet()) {
            int matchNumbers = lottoPlay.getMatchNumbers(lottoNumbers.get(integer), winningNumber);

            winning.record(matchNumbers);
        }

        resultView.printStatistics(winning, inputBuyAmount);
    }
}
