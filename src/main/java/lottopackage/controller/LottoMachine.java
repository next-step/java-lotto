package lottopackage.controller;

import lottopackage.domain.*;
import lottopackage.view.InputView;
import lottopackage.view.OutputView;
import lottopackage.vo.Lotto;

import java.util.List;

public class LottoMachine {
    public static void lottoMachine() {
        int numOfLotto = numOfLotto();
        List<Lotto> manualLotto = InputView.manualLottos();
        LottoGroup lottoGroup = new LottoGroup(numOfLotto, manualLotto);
        OutputView.printLottoGroup(lottoGroup.getLottoGroup());

        List<Prize> lottoResult = lottoGroup.checkPrize(InputView.winningNumberAndBonusBall());
        OutputView.printLottoResult(lottoResult, lottoGroup.getLottoGroup().size());
    }

    private static int numOfLotto() {
        int purchaseAmount = InputView.purchaseAmount();
        int numOfLotto = Lotto.purchaseLotto(purchaseAmount);
        OutputView.printNumOfLotto(numOfLotto);
        return numOfLotto;
    }

}
