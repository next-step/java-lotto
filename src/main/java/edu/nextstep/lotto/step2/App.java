package edu.nextstep.lotto.step2;

import edu.nextstep.lotto.step2.domain.LottoList;
import edu.nextstep.lotto.step2.domain.WinningList;
import edu.nextstep.lotto.step2.view.InputView;
import edu.nextstep.lotto.step2.view.ResultView;

public class App {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        int purchaseAmount = inputView.getPurchaseAmount();

        LottoList lottoList = new LottoList(purchaseAmount);

        resultView.outputNumberOfPurchase(lottoList);
        resultView.outputLottoList(lottoList);

        WinningList winningList = new WinningList(inputView.getWinningNumber());

        resultView.outputStatistics(lottoList, winningList);
        resultView.outputRate(lottoList, winningList, purchaseAmount);
    }
}
