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
        Map<Integer, List<Integer>> lottos = lottoService.getLottos();

        ResultView.printLottoNumbers(lottos);
    }
}
