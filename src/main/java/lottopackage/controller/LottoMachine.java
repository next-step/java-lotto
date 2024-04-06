package lottopackage.controller;

import lottopackage.domain.Lotto;
import lottopackage.domain.LottoGroup;
import lottopackage.domain.Prize;
import lottopackage.view.InputView;
import lottopackage.view.OutputView;

import java.util.List;

public class LottoMachine {
    /* Method */
    public int numOfLotto() {
        int purchaseAmount = InputView.purchaseAmount();
        int numOfLotto = Lotto.purchaseLotto(purchaseAmount);
        System.out.println(numOfLotto + "개를 구매했습니다.");
        return numOfLotto;
    }

    public void lottoMachine() {
        int numOfLotto = numOfLotto();
        LottoGroup lottoGroup = new LottoGroup(numOfLotto);
        OutputView.printLottoGroup(lottoGroup.getLottoGroup());
        List<Integer> winningNumber = InputView.winningNumber();
        List<Prize> lottoResult = lottoGroup.isWinning(winningNumber);

        OutputView.printLottoResult(lottoResult, lottoGroup.getLottoGroup().size());
    }
}
