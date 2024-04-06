package lottopackage.controller;

import lottopackage.domain.Lotto;
import lottopackage.domain.LottoGroup;
import lottopackage.domain.Prize;
import lottopackage.view.InputView;
import lottopackage.view.OutputView;

import java.util.List;

public class LottoMachine {
    /* Method */
    private static int numOfLotto() {
        int purchaseAmount = InputView.purchaseAmount();
        int numOfLotto = Lotto.purchaseLotto(purchaseAmount);
        OutputView.printNumOfLotto(numOfLotto);
        return numOfLotto;
    }

    public static void lottoMachine() {
        int numOfLotto = numOfLotto();
        LottoGroup lottoGroup = new LottoGroup(numOfLotto);
        OutputView.printLottoGroup(lottoGroup.getLottoGroup());

        List<Integer> winningNumber = InputView.winningNumber();
        List<Prize> lottoResult = lottoGroup.isWinning(winningNumber);
        OutputView.printLottoResult(lottoResult, lottoGroup.getLottoGroup().size());
    }
}
