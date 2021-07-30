package lotto.controller;

import java.util.ArrayList;
import java.util.List;
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
        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        WinningLotto winningLotto = createWinningLotto(winningNumbers);

        LottoResult lottoResult = new LottoResult(purchasedLottos, winningLotto);
        ResultView.printWinningStatistics(lottoResult.getWinningLottoCounts());
        ResultView.printEarningRate(lottoResult.getEarningRate());
    }

    private static WinningLotto createWinningLotto(List<Integer> integers) {
        return LottoFactory.createWinning(integers);
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
