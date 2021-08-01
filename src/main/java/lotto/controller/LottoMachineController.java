package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lotto.domain.lotto.LottoFactory;
import lotto.domain.lotto.LottoResult;
import lotto.domain.lotto.NormalLotto;
import lotto.domain.lotto.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMachineController {

    public static void main(String[] args) {
        List<NormalLotto> purchasedLottos = purchaseLotto();
        ResultView.printPurchasedLottos(purchasedLottos);
        Set<Integer> winningNumbers = InputView.inputWinningNumbers();
        int winningBonusNumber = InputView.inputWinningBonusNumber();
        WinningLotto winningLotto = LottoFactory.createWinning(winningNumbers, winningBonusNumber);

        LottoResult lottoResult = new LottoResult(purchasedLottos, winningLotto);
        ResultView.printWinningStatistics(lottoResult.getWinningLottoCounts());
        ResultView.printEarningRate(lottoResult.getEarningRate());
    }

    private static List<NormalLotto> purchaseLotto() {
        int totalAmount = InputView.inputTotalAmount();
        int possiblePurchaseLottoCount = LottoFactory.possiblePurchaseLottoCount(totalAmount);

        List<NormalLotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < possiblePurchaseLottoCount; i++) {
            purchasedLottos.add(LottoFactory.createNormal());
        }

        return purchasedLottos;
    }
}
