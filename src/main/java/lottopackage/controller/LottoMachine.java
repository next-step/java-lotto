package lottopackage.controller;

import lottopackage.domain.LottoTicket;
import lottopackage.domain.LottoGroup;
import lottopackage.domain.Prize;
import lottopackage.view.InputView;
import lottopackage.view.OutputView;

import java.util.List;
import java.util.Set;

public class LottoMachine {
    /* Method */
    public static void lottoMachine() {
        int numOfLotto = numOfLotto();
        LottoGroup lottoGroup = new LottoGroup(numOfLotto);
        OutputView.printLottoGroup(lottoGroup.getLottoGroup());

        Set<Integer> winningNumber = InputView.winningNumber();
        List<Prize> lottoResult = lottoGroup.isWinning(winningNumber);
        OutputView.printLottoResult(lottoResult, lottoGroup.getLottoGroup().size());
    }

    private static int numOfLotto() {
        int purchaseAmount = InputView.purchaseAmount();
        int numOfLotto = LottoTicket.purchaseLotto(purchaseAmount);
        OutputView.printNumOfLotto(numOfLotto);
        return numOfLotto;
    }
}
