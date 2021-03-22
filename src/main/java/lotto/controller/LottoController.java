package lotto.controller;

import lotto.domain.LottoPlay;
import lotto.domain.Winning;
import lotto.dto.IssueNumber;
import lotto.dto.LottoNumbers;
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

        playManualLotto();

        lottoPlay.createLotto(inputBuyAmount);
        
        ResultView resultView = new ResultView();

        Map<IssueNumber, LottoNumbers> totalLottoNumbers = lottoPlay.getLottoNumbers();
        resultView.printLottoNumbers(totalLottoNumbers);

        List<Integer> winningNumber = inputView.inputWinningNumber();
        int bonusNumber = inputView.bonusBall();

        Winning winning = new Winning();
        for (IssueNumber issueNumber : totalLottoNumbers.keySet()) {
            int countMatchNumber = totalLottoNumbers.get(issueNumber).countMatchNumber(winningNumber);
            boolean bonusBall = totalLottoNumbers.get(issueNumber).isContain(bonusNumber);

            winning.record(countMatchNumber, bonusBall);
        }

        resultView.printStatistics(winning, inputBuyAmount);
    }

    public void playManualLotto() {
        Map<Integer, List<Integer>> manualLotto =  inputView.manualLottoNumber(inputView.countManualLotto());
        manualLotto.keySet()
                .forEach(count -> lottoPlay.createLottoByManual(manualLotto.get(count)));
    }
}
