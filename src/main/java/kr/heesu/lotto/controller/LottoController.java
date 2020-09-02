package kr.heesu.lotto.controller;

import kr.heesu.lotto.domain.*;
import kr.heesu.lotto.view.ViewResolver;

public class LottoController {

    private final ViewResolver viewResolver;

    private LottoController(ViewResolver viewResolver) {
        this.viewResolver = viewResolver;
    }

    public static LottoController of() {
        return new LottoController(ViewResolver.of());
    }

    public void main() {
        try {
            PurchaseAmount purchaseAmount = PurchaseAmount.of(
                    viewResolver.getPurchaseAmount());
            ManualCount count = ManualCount.of(
                    viewResolver.getManualAmount(),
                    purchaseAmount);
            LottoGame lottoGame = LottoGame.of(
                    purchaseAmount,
                    viewResolver.getInputForManualStringLottos(count));

            viewResolver.printPurchaseAmount(purchaseAmount, count);
            viewResolver.printMultipleLotto(lottoGame.toString());

            WinningLotto winningLotto = WinningLotto.of(
                    viewResolver.getWinningLotto(),
                    viewResolver.getBonusNumbers());

            LottoStatistics statistics = lottoGame.matches(winningLotto);
            viewResolver.printLottoStatistics(statistics);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
    }

}
