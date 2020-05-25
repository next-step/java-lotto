package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoMatchResult;
import lotto.domain.LottoNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();
        LottoGame lottoGame = new LottoGame(purchaseAmount);

        ResultView.printPurchaseCount(lottoGame.getPurchaseCount());

        List<LottoNumbers> lottoNumbersGroup = lottoGame.createAutoLottoNumbers();
        ResultView.printLottoNumbers(lottoNumbersGroup);

        LottoNumbers lastWinLottoNumbers = LottoNumbers.newInstance(InputView.getLastWeekLottoNumbers());
        int bonusNumber = InputView.getBonusNumber(lastWinLottoNumbers);

        LottoMatchResult lottoMatchResult = lottoGame.calculateMatchCount(lastWinLottoNumbers, bonusNumber);
        ResultView.printMatchResult(lottoMatchResult);

        double profitRate = lottoMatchResult.calculateProfitRate(purchaseAmount);
        ResultView.printProfitRate(profitRate, lottoMatchResult.getProfitOrLoss(profitRate));
    }
}
