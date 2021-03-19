package lotto.controller;

import lotto.dto.LottoNumber;
import lotto.domain.LottoPlay;
import lotto.domain.Winning;
import lotto.dto.IssueNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private final InputView inputView;
    private final LottoPlay lottoPlay;

    public LottoController(InputView inputView, LottoPlay lottoPlay) {
        this.inputView = inputView;
        this.lottoPlay = lottoPlay;
    }

    public void run() {
        int inputBuyAmount = inputView.inputBuyAmount();
        
        lottoPlay.createLotto(inputBuyAmount);
        
        ResultView resultView = new ResultView();

        Map<IssueNumber, List<LottoNumber>> lottoNumbers = lottoPlay.getLottoNumbers();
        resultView.printLottoNumbers(lottoNumbers);

        List<Integer> winningNumber = inputView.inputWinningNumber();
        int bonusBall = inputView.bonusBall();

        Winning winning = new Winning();

        for (IssueNumber issueNumber : lottoNumbers.keySet()) {
            int matchNumbers = lottoPlay.getMatchNumbers(lottoNumbers.get(issueNumber), winningNumber);

            winning.record(matchNumbers);
        }

        resultView.printStatistics(winning, inputBuyAmount);
    }
}
