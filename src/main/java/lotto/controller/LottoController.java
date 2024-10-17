package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoController {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();

        LottoService lottoService = new LottoService();

        int lottoCount = lottoService.calculateLottoCount(purchaseAmount);
        ResultView.printPurchaseLottoCount(lottoCount);

        lottoService.purchaseLottos(lottoCount);
        Map<Integer, List<Integer>> lottos = lottoService.provideLottos();
        ResultView.printLottoNumbers(lottos);

        String lastWeekWinningNumbers = InputView.inputLastWeekWinningNumbers();

        Map<Integer, Integer> winningStatics = lottoService.provideWinningStatics(lastWeekWinningNumbers, lottos);
        ResultView.printWinningStatics(winningStatics);

        float returnRate = lottoService.provideReturnRate(purchaseAmount, winningStatics);
        ResultView.printReturnRate(returnRate);
    }
}
