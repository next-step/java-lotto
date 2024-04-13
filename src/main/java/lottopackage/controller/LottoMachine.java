package lottopackage.controller;

import lottopackage.domain.*;
import lottopackage.view.InputView;
import lottopackage.view.OutputView;

import java.util.List;
import java.util.Set;

public class LottoMachine {
    public static void lottoMachine() {
        int numOfLotto = numOfLotto();
        LottoGroup lottoGroup = new LottoGroup(numOfLotto);
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
