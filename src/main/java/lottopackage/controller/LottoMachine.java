package lottopackage.controller;

import lottopackage.domain.Lotto;
import lottopackage.domain.LottoBall;
import lottopackage.domain.LottoGroup;
import lottopackage.domain.Prize;
import lottopackage.view.InputView;
import lottopackage.view.OutputView;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LottoMachine {
    /* Method */
    public static void lottoMachine() {
        int numOfLotto = numOfLotto();
        LottoGroup lottoGroup = new LottoGroup(numOfLotto);
        OutputView.printLottoGroup(lottoGroup.getLottoGroup());

        List<Prize> lottoResult = lottoGroup.isWinning(winningNumber());
        OutputView.printLottoResult(lottoResult, lottoGroup.getLottoGroup().size());
    }

    private static int numOfLotto() {
        int purchaseAmount = InputView.purchaseAmount();
        int numOfLotto = Lotto.purchaseLotto(purchaseAmount);
        OutputView.printNumOfLotto(numOfLotto);
        return numOfLotto;
    }

    private static Set<LottoBall> winningNumber() {
        Set<Integer> winningNumberInteger = InputView.winningNumber();
        Set<LottoBall> winningNumber = new HashSet<>();
        Iterator<Integer> iteratorWinningNumber = winningNumberInteger.iterator();

        while (iteratorWinningNumber.hasNext()) {
            winningNumber.add(new LottoBall(iteratorWinningNumber.next()));
        }
        return winningNumber;
    }
}
