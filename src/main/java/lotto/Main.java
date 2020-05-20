package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoMatchResult;
import lotto.domain.LottoNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(InputView.getPurchaseAmount());

        ResultView.printPurchaseCount(lottoGame.getPurchaseCount());

        List<LottoNumbers> lottoNumbers = lottoGame.createLottoNumbers();
        ResultView.printLottoNumbers(lottoNumbers);

        LottoNumbers lastWeekLottoNumbers = LottoNumbers.newInstance(InputView.getLastWeekLottoNumbers());

        LottoMatchResult lottoMatchResult = LottoMatchResult.newInstance(lastWeekLottoNumbers, lottoNumbers);
        lottoMatchResult.calculateMatchCount();

        ResultView.printMatchResult(lottoMatchResult);
    }
}
