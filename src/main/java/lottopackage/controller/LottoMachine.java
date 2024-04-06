package lottopackage.controller;

import lottopackage.domain.Lotto;
import lottopackage.domain.LottoGroup;
import lottopackage.domain.Prize;
import lottopackage.view.InputView;
import lottopackage.view.OutputView;

import java.util.List;

public class LottoMachine {
    /* Member variable */
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    /* Method */
    public int numOfLotto() {
        int purchaseAmount = inputView.purchaseAmount();
        int numOfLotto = Lotto.purchaseLotto(purchaseAmount);
        System.out.println(numOfLotto + "개를 구매했습니다.");
        return numOfLotto;
    }

    public void lottoMachine() {
        int numOfLotto = numOfLotto();
        LottoGroup lottoGroup = new LottoGroup(numOfLotto);
        outputView.printLottoGroup(lottoGroup.getLottoGroup());
        List<Integer> winningNumber = inputView.winningNumber();
        List<Prize> lottoResult = lottoGroup.isWinning(winningNumber);

        outputView.printLottoResult(lottoResult, lottoGroup.getLottoGroup().size());
    }
}
