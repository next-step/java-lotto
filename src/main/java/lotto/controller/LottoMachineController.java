package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoFactory;
import lotto.domain.lotto.LottoResult;
import lotto.domain.lotto.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMachineController {

    public static void main(String[] args) {
        List<Lotto> purchasedLottos = createPurchasedLottos();
        ResultView.printPurchasedLottos(purchasedLottos);
        WinningLotto winningLotto = createWinningLotto(InputView.inputWinningNumbers());

        LottoResult lottoResult = new LottoResult(purchasedLottos, winningLotto);
        ResultView.printWinningStatistics(lottoResult.getMatchLottoCounts());
        ResultView.printEarningRate(lottoResult.getEarningRate());
    }

    private static WinningLotto createWinningLotto(List<Integer> integers) {
        return LottoFactory.createWinning(integers);
    }

    private static List<Lotto> createPurchasedLottos() {
        long totalAmount = InputView.inputTotalAmount();
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < totalAmount / LottoFactory.getLottoPrice(); i++) {
            purchasedLottos.add(LottoFactory.createNormal());
        }

        return purchasedLottos;
    }
}
